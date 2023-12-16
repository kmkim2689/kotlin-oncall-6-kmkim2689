package oncall

import oncall.controller.CallController
import oncall.util.isWeekendCallInputValid
import oncall.util.throwInvalidInputException

fun main() {
    CallController.startCallDecision()
}
