package subtask2

import java.time.DateTimeException
import java.time.LocalTime

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        return try {
            val time = LocalTime.of(hour.toInt(), minute.toInt())
            when (time.minute) {
                0 -> "${time.hour.toText()} o' clock"
                in 1..14, in 16..29 -> "${time.minute.toText()} minutes past ${time.hour.toText()}"
                15 -> "quarter past ${time.hour.toText()}"
                30 -> "half past ${time.hour.toText()}"
                in 31..44, in 46..59 -> "${(60 - time.minute).toText()} minutes to ${time.plusHours(1).hour.toText()}"
                45 -> "quarter to ${time.plusHours(1).hour.toText()}"
                else -> ""
            }
        } catch (e: DateTimeException) {
            ""
        }
    }

}

private fun Int.toText(): String {
    return when (this) {
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        7 -> "seven"
        8 -> "eight"
        9 -> "nine"
        10 -> "ten"
        11 -> "eleven"
        12 -> "twelve"
        13 -> "thirteen"
        14, 16, 17, 18, 19 -> "${(this / 10).toText()}teen".trim()
        15 -> "fifteen"
        in 20..29 -> "twenty ${(this % 10).toText()}".trim()
        // no need to implement further for current task
        else -> ""
    }
}