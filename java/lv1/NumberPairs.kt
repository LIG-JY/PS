package lv1

class NumberPairs {

    fun solution(X: String, Y: String): String {
        val xCounter = makeCounter(X)
        val yCounter = makeCounter(Y)
        val answer = xCounter
            .entries
            .filter { it.key in yCounter }
            .joinToString("") { it.key.toString().repeat(minOf(it.value, yCounter[it.key]!!)) }
        if (answer.isEmpty()) return "-1"
        if (answer.all { it == '0' }) return "0"
        return answer
    }

    private fun makeCounter(input: String): Map<Char, Int> {
        return input.groupingBy { it }.eachCount().toSortedMap(reverseOrder())
    }

}