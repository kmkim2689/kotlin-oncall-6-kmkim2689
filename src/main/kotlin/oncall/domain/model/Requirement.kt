package oncall.domain.model

data class Requirement(
    val month: Int,
    val startDay: String,
    val weekdayCallMembers: List<String>,
    val weekendCallMembers: List<String>
)
