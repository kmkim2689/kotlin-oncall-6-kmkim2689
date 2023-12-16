package oncall.util

import oncall.constant.Constants.FRIDAY
import oncall.constant.Constants.MONDAY
import oncall.constant.Constants.SATURDAY
import oncall.constant.Constants.SUNDAY
import oncall.constant.Constants.THURSDAY
import oncall.constant.Constants.TUESDAY
import oncall.constant.Constants.WEDNESDAY
import java.lang.IllegalArgumentException

val months = (1..12).map { it.toString() }.toList()
val days = listOf(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY)

fun String.toValidatedMonth(): String {
    if (this !in months) throw IllegalArgumentException()
    return this
}