package oncall.util

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
    if (size != 2) throw IllegalArgumentException(EXCEPTION_INVALID_VALUE)
    if (this[0] !in months) throw IllegalArgumentException(EXCEPTION_INVALID_VALUE)
    if (this[1] !in days) throw IllegalArgumentException(EXCEPTION_INVALID_VALUE)
}

fun List<String>.isWeekdayCallInputValid() {
    if (size !in (5..35)) throw IllegalArgumentException(EXCEPTION_INVALID_VALUE)
}