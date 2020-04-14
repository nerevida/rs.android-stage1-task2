package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val lastPair = fibonacci().asSequence().takeWhile { n >= it.first * it.second }.last()
        return if (n == lastPair.first * lastPair.second) {
            intArrayOf(lastPair.first, lastPair.second, 1)
        } else {
            intArrayOf(lastPair.second, lastPair.first.plus(lastPair.second), 0)
        }
    }

    private fun fibonacci(): Sequence<Pair<Int, Int>> {
        return generateSequence(Pair(0, 1), { Pair(it.second, it.first.plus(it.second)) })
    }
}
