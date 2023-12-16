package oncall.domain

import oncall.domain.model.CallInfo
import oncall.domain.model.DayOfWeekInfo
import oncall.domain.model.MonthlyInfo
import oncall.domain.model.Requirement

class CallManager(
    private val requirement: Requirement
) {
    private val weekdayMembers = requirement.weekdayCallMembers
    private val weekendMembers = requirement.weekendCallMembers
    private val numOfWorkers = weekdayMembers.size

    fun getCallData(): List<CallInfo> {
        TODO("각 일의 요일에 따라서 근무자 초기에 배정하는 기능")
        TODO("초기의 결과를 검증하여 2일 연속 근무자 존재 시 뒷 사람과 순서를 바꾸는 기능")
        TODO("최종 결과를 반환하는 기능")
    }

    fun getInitialCallData(): List<CallInfo> {
        val callResult = ArrayList<CallInfo>()
        val month = requirement.month
        val startDay = requirement.startDay

        val monthlyInfo = MonthlyInfo.getMonthlyInfoByNumOfMonth(month)

        val weekendRemainders = getWeekendRemainders(startDay)
        val holidays = monthlyInfo!!.holidays
        val numOfDays = monthlyInfo.numOfDays
        val remaindersByStartDayOfWeek = getRemaindersByStartDayOfWeek(getDayOfWeekInfoByDayOfWeek(startDay)!!)

        var weekdayIdx = 0
        var weekendIdx = 0

        for (i in 1..numOfDays) {
            val dayOfWeekInfo = getDayOfWeekInfoByIndex(remaindersByStartDayOfWeek.indexOf(i % 7))
            if (i % 7 in weekendRemainders || i in holidays) {
                callResult.add(CallInfo(month, i, dayOfWeekInfo.dayOfWeek, weekendMembers[weekendIdx % numOfWorkers], true))
                weekendIdx++
                continue
            }

            callResult.add(CallInfo(month, i, dayOfWeekInfo.dayOfWeek, weekdayMembers[weekdayIdx % numOfWorkers], false))
            weekdayIdx++
        }

        return callResult
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