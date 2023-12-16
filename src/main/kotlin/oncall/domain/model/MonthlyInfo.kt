package oncall.domain.model

import oncall.constant.Constants.NUM_OF_DAYS_28
import oncall.constant.Constants.NUM_OF_DAYS_30
import oncall.constant.Constants.NUM_OF_DAYS_31

enum class MonthlyInfo(
    val month: Int,
    val numOfDays: Int,
    val holidays: List<Int>
) {
    JANUARY(1, NUM_OF_DAYS_31, listOf(1)),
    FEBRUARY(2, NUM_OF_DAYS_28, emptyList()),
    MARCH(3, NUM_OF_DAYS_31, listOf(1)),
    APRIL(4, NUM_OF_DAYS_30, emptyList()),
    MAY(5, NUM_OF_DAYS_31, listOf(5)),
    JUNE(6, NUM_OF_DAYS_30, listOf(6)),
    JULY(7, NUM_OF_DAYS_31, emptyList()),
    AUGUST(8, NUM_OF_DAYS_31, listOf(15)),
    SEPTEMBER(9, NUM_OF_DAYS_30, emptyList()),
    OCTOBER(10, NUM_OF_DAYS_31, listOf(3, 9)),
    NOVEMBER(11, NUM_OF_DAYS_30, emptyList()),
    DECEMBER(12, NUM_OF_DAYS_31, listOf(25));

    companion object {
        fun getMonthlyInfoByNumOfMonth(month: Int): MonthlyInfo? {
            return MonthlyInfo.entries.find { it.month == month }
        }
    }
}