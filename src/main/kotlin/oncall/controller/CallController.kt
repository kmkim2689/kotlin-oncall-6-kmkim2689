package oncall.controller

import oncall.domain.Requirement
import oncall.view.InputView

object CallController {

    fun startCallDecision() {
        val startInfo = InputView.getCallStartInfo()
        val memberInfo = InputView.getCallMembers()
        val requirement = Requirement(
            month = startInfo[0].toInt(),
            startDay = startInfo[1],
            weekdayCallMembers = memberInfo[0],
            weekendCallMembers = memberInfo[1]
        )
    }
}