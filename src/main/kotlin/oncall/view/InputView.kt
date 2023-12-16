package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.constant.Constants.SEPARATOR_INPUT
import oncall.constant.ExceptionMessages.ERROR
import oncall.constant.ExceptionMessages.EXCEPTION_INVALID_VALUE
import oncall.constant.StepMessages.STEP_INPUT_START_DAY
import oncall.constant.StepMessages.STEP_INPUT_WEEKDAY_CALL
import oncall.constant.StepMessages.STEP_INPUT_WEEKEND_CALL
import oncall.util.isStartDayInputValid
import oncall.util.isWeekdayCallInputValid

object InputView {
    fun getCallStartInfo(): List<String> = try {
        println(STEP_INPUT_START_DAY)
        val callStartInfo = Console.readLine().trim().split(SEPARATOR_INPUT)
        callStartInfo.isStartDayInputValid()
        callStartInfo
    } catch (e: IllegalArgumentException) {
        println("$ERROR ${e.message}")
        getCallStartInfo()
    }

    fun getCallMembers(): List<List<String>> = try {
        print(STEP_INPUT_WEEKDAY_CALL)
        val weekdayCallMembers = Console.readLine().trim().split(SEPARATOR_INPUT)
        weekdayCallMembers.isWeekdayCallInputValid()

//        print(STEP_INPUT_WEEKEND_CALL)
//        val weekendCallMembers = Console.readLine().trim().split(SEPARATOR_INPUT)
//
//
    } catch (e: IllegalArgumentException) {
        println("$ERROR ${e.message}")
        getCallMembers()
    }
}