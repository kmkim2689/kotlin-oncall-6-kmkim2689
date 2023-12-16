package oncall

import oncall.util.isWeekendCallInputValid
import oncall.util.throwInvalidInputException

fun main() {
    listOf("r", "r", "a").sorted().zip(listOf("a", "r", "r").sorted()) { weekendMember, weekdayMember ->
        if (weekendMember != weekdayMember) throwInvalidInputException() else println("same")
    }
}
