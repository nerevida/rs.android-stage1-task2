package subtask4

class Pangram {

    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'y')
    val consonants = listOf(
        'b',
        'c',
        'd',
        'f',
        'g',
        'h',
        'j',
        'k',
        'l',
        'm',
        'n',
        'p',
        'q',
        'r',
        's',
        't',
        'w',
        'v',
        'x',
        'z'
    )

    fun getResult(inputString: String): String {
        return if (!inputString.isBlank()) {
            val words = inputString.trim().split("\\s+".toRegex())
            if (isPangram(inputString)) {
                updateString(words, vowels)
            } else updateString(words, consonants)
        } else ""
    }

    private fun isPangram(inputString: String): Boolean {
        return inputString.toLowerCase().toList().containsAll(consonants.plus(vowels))
    }


    private fun String.upperCase(chars: List<Char>): Any {
        return this.map { if (it in chars) it.toUpperCase() else it }.joinToString("")
    }

    private fun updateString(words: List<String>, chars: List<Char>): String {
        return words.asSequence()
            .map { s -> s.prependIndent(s.count { chars.contains(it.toLowerCase()) }.toString()) }
            .map { it.upperCase(chars) }
            .toList()
            .sortedBy { it.toString().get(0) }.joinToString(" ")
    }
}