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
    val isWeekend: Boolean
) {
    SUNDAY(DOW_SUNDAY, true),
    MONDAY(DOW_MONDAY, false),
    TUESDAY(DOW_TUESDAY, false),
    WEDNESDAY(DOW_WEDNESDAY, false),
    THURSDAY(DOW_THURSDAY, false),
    FRIDAY(DOW_FRIDAY, false),
    SATURDAY(DOW_SATURDAY, true),
}