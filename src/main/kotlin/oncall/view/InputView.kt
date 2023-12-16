package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.constant.Constants.SEPARATOR_INPUT
import oncall.constant.ExceptionMessages.ERROR
import oncall.constant.ExceptionMessages.EXCEPTION_INVALID_VALUE
import oncall.util.isStartDayInputValid

object InputView {
    fun getCallStartInfo(): List<String> = try {
        val callStartInfo = Console.readLine().trim().split(SEPARATOR_INPUT)
        callStartInfo.isStartDayInputValid()
        callStartInfo
    } catch (e: IllegalArgumentException) {
        println("$ERROR ${e.message}")
        getCallStartInfo()
    }
}