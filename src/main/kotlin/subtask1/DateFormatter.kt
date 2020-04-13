package subtask1

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val locale = Locale ("ru")

        return try {
            val date = LocalDate.of(year.toInt(), month.toInt(), day.toInt());
            "${date.dayOfMonth} ${date.month.getDisplayName(TextStyle.FULL, locale)}, ${date.dayOfWeek.getDisplayName(TextStyle.FULL, locale)}"
        } catch (e: DateTimeException) {
            "Такого дня не существует"
        }
    }
}
