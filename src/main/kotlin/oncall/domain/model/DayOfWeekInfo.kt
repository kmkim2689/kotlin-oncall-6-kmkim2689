package oncall.domain.model

import oncall.constant.Constants.DOW_FRIDAY
import oncall.constant.Constants.DOW_MONDAY
import oncall.constant.Constants.DOW_SATURDAY
import oncall.constant.Constants.DOW_SUNDAY
import oncall.constant.Constants.DOW_THURSDAY
import oncall.constant.Constants.DOW_TUESDAY
import oncall.constant.Constants.DOW_WEDNESDAY

enum class DayOfWeekInfo(
    val dayOfWeek: String,
    val isWeekend: Boolean,
    val weekendRemainder: List<Int>
) {
    SUNDAY(DOW_SUNDAY, true, listOf(0, 1)),
    MONDAY(DOW_MONDAY, false, listOf(0, 6)),
    TUESDAY(DOW_TUESDAY, false, listOf(5, 6)),
    WEDNESDAY(DOW_WEDNESDAY, false, listOf(4, 5)),
    THURSDAY(DOW_THURSDAY, false, listOf(3, 4)),
    FRIDAY(DOW_FRIDAY, false, listOf(2, 3)),
    SATURDAY(DOW_SATURDAY, true, listOf(1, 2));

    companion object {
        fun getDayOfWeekByName(name: String): DayOfWeekInfo? {
            return entries.find { it.dayOfWeek == name }
        }
    }
}