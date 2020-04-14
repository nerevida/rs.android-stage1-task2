package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        return if (a.filter { it.toLowerCase() in b.toLowerCase() }.toUpperCase() == b) {
            "YES"
        } else "NO"
    }
}
