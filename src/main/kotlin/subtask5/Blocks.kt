package subtask5

import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        return when (blockB) {
            String::class -> operateStrings(blockA)
            Int::class -> operateInts(blockA)
            LocalDate::class -> operateDates(blockA)
            else -> ""
        }
    }

    private fun operateStrings(blockA: Array<Any>): String {
        var s = ""
        blockA.forEach {
            if (it is String) {
                s = s.plus(it)
            }
        }
        return s
    }

    private fun operateInts(blockA: Array<Any>): Int {
        var s = 0
        blockA.forEach {
            if (it is Int) {
                s += it
            }
        }
        return s
    }

    private fun operateDates(blockA: Array<Any>): LocalDate {
        var currentDate = LocalDate.now()
        return currentDate
    }
}

