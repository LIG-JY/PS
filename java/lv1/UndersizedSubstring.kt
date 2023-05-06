package lv1


class UndersizedSubstring {
    fun solution(t: String, p: String): Int {
        val patternLength = p.length
        var answer = 0
        for (i in 0..t.length - patternLength) {
            val subString = t.substring(i, i + patternLength)
            if (subString.toBigInteger() <= p.toBigInteger()) {
                answer++
            }
        }
        return answer
    }
}