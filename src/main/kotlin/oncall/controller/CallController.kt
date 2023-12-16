package oncall.controller

import oncall.domain.CallManager
import oncall.domain.Requirement
import oncall.view.InputView

object CallController {

    private lateinit var callManager: CallManager

    fun startCallDecision() {
        initializeCallManager()

    }

    private fun initializeCallManager() {
        val startInfo = InputView.getCallStartInfo()
        val memberInfo = InputView.getCallMembers()
        val requirement = Requirement(
            month = startInfo[0].toInt(),
            startDay = startInfo[1],
            weekdayCallMembers = memberInfo[0],
            weekendCallMembers = memberInfo[1]
        )

        callManager = CallManager(requirement)
    }
}