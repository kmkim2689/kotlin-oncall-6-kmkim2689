package oncall.domain.model

data class CallInfo(
    val month: Int,
    var dayOfMonth: Int,
    var dayOfWeek: String,
    var worker: String,
    var isHoliday: Boolean = false
)
