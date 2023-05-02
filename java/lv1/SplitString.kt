package lv1

class SplitString {
    fun solution(s: String): Int = split(s)

    private fun split(s: String): Int {
        if (s.length < 2) return s.length

        var i = 0
        var j = 0

        s.forEach { c ->
            if (c == s[0]) i++ else j++
            if (i == j) return 1 + split(s.substring(i + j))
        }

        return 1
    }
}
