package oncall.domain

import oncall.domain.model.CallInfo
import oncall.domain.model.Requirement

class CallManager(
    private val requirement: Requirement
) {
    fun getCallData(): List<CallInfo> {
        TODO("각 일의 요일에 따라서 근무자 초기에 배정하는 기능")
        TODO("초기의 결과를 검증하여 2일 연속 근무자 존재 시 뒷 사람과 순서를 바꾸는 기능")
        TODO("최종 결과를 반환하는 기능")
    }

    /*fun getInitialCallData(): List<CallInfo> {
        val month = requirement.month
        val startDay = requirement.startDay

        // 각 요일의 나머지
    }*/
}