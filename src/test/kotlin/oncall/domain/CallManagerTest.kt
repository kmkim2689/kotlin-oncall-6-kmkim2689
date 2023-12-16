package oncall.domain

import oncall.domain.model.CallInfo
import oncall.domain.model.Requirement
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CallManagerTest {

    @Test
    fun `배정에 필요한 정보를 넘겨주었을 때 배정 결과를 반환`() {
        val callManager = CallManager(
            Requirement(5, "월",
                listOf("허브", "쥬니", "말랑", "라온", "헤나", "우코", "에단", "수달"),
                listOf("우코", "허브", "에단", "말랑", "수달", "라온", "쥬니", "헤나")
            )
        )
        val actual = callManager.getCallData()
        assertThat(actual).isEqualTo(listOf(
            CallInfo(month=5, dayOfMonth=1, dayOfWeek="월", worker="허브", isHoliday=false),
            CallInfo(month=5, dayOfMonth=2, dayOfWeek="화", worker="쥬니", isHoliday=false),
            CallInfo(month=5, dayOfMonth=3, dayOfWeek="수", worker="말랑", isHoliday=false),
            CallInfo(month=5, dayOfMonth=4, dayOfWeek="목", worker="라온", isHoliday=false),
            CallInfo(month=5, dayOfMonth=5, dayOfWeek="금", worker="우코", isHoliday=true),
            CallInfo(month=5, dayOfMonth=6, dayOfWeek="토", worker="허브", isHoliday=false),
            CallInfo(month=5, dayOfMonth=7, dayOfWeek="일", worker="에단", isHoliday=false),
            CallInfo(month=5, dayOfMonth=8, dayOfWeek="월", worker="헤나", isHoliday=false),
            CallInfo(month=5, dayOfMonth=9, dayOfWeek="화", worker="우코", isHoliday=false),
            CallInfo(month=5, dayOfMonth=10, dayOfWeek="수", worker="에단", isHoliday=false),
            CallInfo(month=5, dayOfMonth=11, dayOfWeek="목", worker="수달", isHoliday=false),
            CallInfo(month=5, dayOfMonth=12, dayOfWeek="금", worker="허브", isHoliday=false),
            CallInfo(month=5, dayOfMonth=13, dayOfWeek="토", worker="말랑", isHoliday=false),
            CallInfo(month=5, dayOfMonth=14, dayOfWeek="일", worker="수달", isHoliday=false),
            CallInfo(month=5, dayOfMonth=15, dayOfWeek="월", worker="쥬니", isHoliday=false),
            CallInfo(month=5, dayOfMonth=16, dayOfWeek="화", worker="말랑", isHoliday=false),
            CallInfo(month=5, dayOfMonth=17, dayOfWeek="수", worker="라온", isHoliday=false),
            CallInfo(month=5, dayOfMonth=18, dayOfWeek="목", worker="헤나", isHoliday=false),
            CallInfo(month=5, dayOfMonth=19, dayOfWeek="금", worker="우코", isHoliday=false),
            CallInfo(month=5, dayOfMonth=20, dayOfWeek="토", worker="라온", isHoliday=false),
            CallInfo(month=5, dayOfMonth=21, dayOfWeek="일", worker="쥬니", isHoliday=false),
            CallInfo(month=5, dayOfMonth=22, dayOfWeek="월", worker="에단", isHoliday=false),
            CallInfo(month=5, dayOfMonth=23, dayOfWeek="화", worker="수달", isHoliday=false),
            CallInfo(month=5, dayOfMonth=24, dayOfWeek="수", worker="허브", isHoliday=false),
            CallInfo(month=5, dayOfMonth=25, dayOfWeek="목", worker="쥬니", isHoliday=false),
            CallInfo(month=5, dayOfMonth=26, dayOfWeek="금", worker="말랑", isHoliday=false),
            CallInfo(month=5, dayOfMonth=27, dayOfWeek="토", worker="헤나", isHoliday=false),
            CallInfo(month=5, dayOfMonth=28, dayOfWeek="일", worker="우코", isHoliday=false),
            CallInfo(month=5, dayOfMonth=29, dayOfWeek="월", worker="라온", isHoliday=false),
            CallInfo(month=5, dayOfMonth=30, dayOfWeek="화", worker="헤나", isHoliday=false),
            CallInfo(month=5, dayOfMonth=31, dayOfWeek="수", worker="우코", isHoliday=false)
        ))
    }
}