package oncall.view

import oncall.domain.model.CallInfo

object OutputView {
    fun printResult(callResult: List<CallInfo>) {
        var result = ""
        callResult.onEach {
            result += "${it.month}월 ${it.dayOfMonth}일 ${it.dayOfWeek}${getHolidayMark(it.isHoliday)} ${it.worker}\n"
        }
        println(result)
    }

    fun getHolidayMark(isHoliday: Boolean) = when (isHoliday) {
        true -> "(휴일)"
        false -> ""
    }
}