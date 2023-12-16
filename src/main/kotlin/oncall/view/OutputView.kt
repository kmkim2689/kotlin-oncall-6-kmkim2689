package oncall.view

import oncall.constant.StepMessages.STEP_DAY_NUM
import oncall.constant.StepMessages.STEP_HOLIDAY
import oncall.constant.StepMessages.STEP_MONTH
import oncall.constant.StepMessages.STEP_NONE
import oncall.domain.model.CallInfo

object OutputView {
    fun printResult(callResult: List<CallInfo>) {
        var result = STEP_NONE
        callResult.onEach {
            result += "${it.month}$STEP_MONTH ${it.dayOfMonth}$STEP_DAY_NUM ${it.dayOfWeek}${getHolidayMark(it.isHoliday)} ${it.worker}\n"
        }
        println(result)
    }

    fun getHolidayMark(isHoliday: Boolean) = when (isHoliday) {
        true -> STEP_HOLIDAY
        false -> STEP_NONE
    }
}