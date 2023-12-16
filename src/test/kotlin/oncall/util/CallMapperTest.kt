package oncall.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CallMapperTest {

    @Test
    fun `정상적인 월과 요일을 입력 시 원활히 통과`() {
        val input = listOf("5", "월")
        assertDoesNotThrow {
            input.isStartDayInputValid()
        }
    }

    @Test
    fun `월과 요일 입력 시 관련없는 데이터 3개 이상을 입력했을 때 오류 발생`() {
        val input = listOf("5", "월", "화")
        assertThrows<IllegalArgumentException> {
            input.isStartDayInputValid()
        }
    }

    @Test
    fun `월을 1에서 12 사이로 입력하지 않은 경우 오류 발생`() {
        val input = listOf("13", "월")
        assertThrows<IllegalArgumentException> {
            input.isStartDayInputValid()
        }
    }

    @Test
    fun `요일을 잘못된 값으로 입력 시 오류 발생`() {
        val input = listOf("13", "훨")
        assertThrows<IllegalArgumentException> {
            input.isStartDayInputValid()
        }
    }

    @Test
    fun `주중 근무자를 올바르게 입력한 경우 통과`() {
        val input = listOf("김기", "문", "가", "나", "다")
        assertDoesNotThrow {
            input.isWeekdayCallInputValid()
        }
    }

    @Test
    fun `주말 근무자를 올바르게 입력한 경우 통과`() {
        val weekdayInput = listOf("김기", "문", "가", "나", "다")
        val input = listOf("가", "나", "다", "문", "김기")
        assertDoesNotThrow {
            input.isWeekendCallInputValid(weekdayInput)
        }
    }

    @Test
    fun `주말 근무자와 주중 근무자가 불일치 시 오류 발생`() {
        val weekdayInput = listOf("김기", "문", "가", "나", "다")
        val weekendInput = listOf("몬", "김기", "가", "나", "다")
        assertThrows<IllegalArgumentException> {
            weekendInput.isWeekendCallInputValid(weekdayInput)
        }
    }

    @Test
    fun `주중 근무자가 수가 맞지 않을 시 오류 발생`() {
        val weekdayInput = listOf("김기", "문")
        assertThrows<IllegalArgumentException> {
            weekdayInput.isWeekdayCallInputValid()
        }
    }

}