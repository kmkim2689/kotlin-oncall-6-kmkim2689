package oncall.util

import net.bytebuddy.pool.TypePool.Resolution.Illegal
import oncall.constant.Constants.FRIDAY
import oncall.constant.Constants.MONDAY
import oncall.constant.Constants.SATURDAY
import oncall.constant.Constants.SUNDAY
import oncall.constant.Constants.THURSDAY
import oncall.constant.Constants.TUESDAY
import oncall.constant.Constants.WEDNESDAY
import oncall.constant.ExceptionMessages.EXCEPTION_INVALID_VALUE
import kotlin.IllegalArgumentException

val months = (1..12).map { it.toString() }.toList()
val days = listOf(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY)

fun List<String>.isStartDayInputValid() {
    if (size != 2 || this[0] !in months || this[1] !in days) throwInvalidInputException()
}

fun List<String>.isWeekdayCallInputValid() {
    if (size !in (5..35)) throwInvalidInputException()
    if (size != this.toSet().size) throwInvalidInputException()
    for (elem in this) {
        if (elem.length !in (1..5)) throwInvalidInputException()
    }
}

fun List<String>.isWeekendCallInputValid(weekdayMembers: List<String>) {
    isWeekdayCallInputValid()
    if (this.size != weekdayMembers.size) throwInvalidInputException()
    this.sorted().zip(weekdayMembers.sorted()) { weekendMember, weekdayMember ->
        if (weekendMember != weekdayMember) throwInvalidInputException()
    }
}

fun throwInvalidInputException() {
    throw IllegalArgumentException(EXCEPTION_INVALID_VALUE)
}