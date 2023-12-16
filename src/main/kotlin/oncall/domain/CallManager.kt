package oncall.domain

import oncall.domain.model.CallInfo
import oncall.domain.model.DayOfWeekInfo
import oncall.domain.model.MonthlyInfo
import oncall.domain.model.Requirement
import java.util.*
import kotlin.collections.ArrayList

class CallManager(
    private val requirement: Requirement
) {
    private var weekdayMembers = requirement.weekdayCallMembers.toMutableList()
    private var weekendMembers = requirement.weekendCallMembers.toMutableList()
    private val numOfWorkers = weekdayMembers.size
    private val month = requirement.month
    private val startDay = requirement.startDay
    private val monthlyInfo = MonthlyInfo.getMonthlyInfoByNumOfMonth(month)
    private val weekendRemainders = getWeekendRemainders(startDay)
    private val holidays = monthlyInfo!!.holidays
    private val numOfDays = monthlyInfo!!.numOfDays
    private val remaindersByStartDayOfWeek = getRemaindersByStartDayOfWeek(getDayOfWeekInfoByDayOfWeek(startDay)!!)

    private val callResult = ArrayList<CallInfo>()

    fun getCallData(): List<CallInfo> {
        setInitialCallData()
        getValidatedCallData()
        return callResult
    }

    fun setInitialCallData() {
        var weekdayIdx = 0
        var weekendIdx = 0

        for (i in 1..numOfDays) {
            val dayOfWeekInfo = getDayOfWeekInfoByIndex(remaindersByStartDayOfWeek.indexOf(i % 7))

            if (i in holidays) {
                callResult.add(CallInfo(month, i, dayOfWeekInfo.dayOfWeek, weekendMembers[weekendIdx % numOfWorkers], true))
                weekendIdx++
                continue
            }

            if (i % 7 in weekendRemainders) {
                callResult.add(CallInfo(month, i, dayOfWeekInfo.dayOfWeek, weekendMembers[weekendIdx % numOfWorkers], false))
                weekendIdx++
                continue
            }

            if (i % 7 !in weekendRemainders) {
                callResult.add(CallInfo(month, i, dayOfWeekInfo.dayOfWeek, weekdayMembers[weekdayIdx % numOfWorkers], false))
                weekdayIdx++
            }
        }
    }

    fun getValidatedCallData() {
        for (i in 0 until callResult.size - 2) {
            if (callResult[i].worker == callResult[i + 1].worker) {
                if (callResult[i + 1].isHoliday || callResult[i + 1].dayOfMonth % 7 in weekendRemainders) {
                    val originalWorkerIndex = weekendMembers.indexOf(callResult[i].worker)
                    val alternativeWorkerIndex = originalWorkerIndex + 1
                    Collections.swap(weekendMembers, originalWorkerIndex, alternativeWorkerIndex)
                }

                if (!callResult[i + 1].isHoliday && callResult[i + 1].dayOfMonth % 7 !in weekendRemainders) {
                    val originalWorkerIndex = weekdayMembers.indexOf(callResult[i].worker)
                    val alternativeWorkerIndex = originalWorkerIndex + 1
                    Collections.swap(weekdayMembers, originalWorkerIndex, alternativeWorkerIndex)
                }

            }
        }

        callResult.clear()
        setInitialCallData()
    }

    fun getDayOfWeekInfoByIndex(index: Int) = when (index) {
        0 -> DayOfWeekInfo.SUNDAY
        1 -> DayOfWeekInfo.MONDAY
        2 -> DayOfWeekInfo.TUESDAY
        3 -> DayOfWeekInfo.WEDNESDAY
        4 -> DayOfWeekInfo.THURSDAY
        5 -> DayOfWeekInfo.FRIDAY
        else -> DayOfWeekInfo.SATURDAY
    }

    fun getRemaindersByStartDayOfWeek(startDayOfWeek: DayOfWeekInfo) = when (startDayOfWeek) {
        DayOfWeekInfo.SUNDAY -> listOf(1, 2, 3, 4, 5, 6, 0)
        DayOfWeekInfo.MONDAY -> listOf(0, 1, 2, 3, 4, 5, 6)
        DayOfWeekInfo.TUESDAY -> listOf(6, 0, 1, 2, 3, 4, 5)
        DayOfWeekInfo.WEDNESDAY -> listOf(5, 6, 0, 1, 2, 3, 4)
        DayOfWeekInfo.THURSDAY -> listOf(4, 5, 6, 0, 1, 2, 3)
        DayOfWeekInfo.FRIDAY -> listOf(3, 4, 5, 6, 0, 1, 2)
        DayOfWeekInfo.SATURDAY -> listOf(2, 3, 4, 5, 6, 0, 1)
    }


    private fun getDayOfWeekInfoByDayOfWeek(dayOfWeek: String) =
        DayOfWeekInfo.getDayOfWeekByName(dayOfWeek)

    private fun getWeekendRemainders(startDay: String): List<Int> =
        DayOfWeekInfo.getDayOfWeekByName(startDay)!!.weekendRemainder
}