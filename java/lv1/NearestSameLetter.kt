package lv1

class NearestSameLetter {
    fun solution(s: String): IntArray {
        val answer = IntArray(s.length)
        val map = mutableMapOf<Char, Int>()
        for (i in s.indices) {
            if (map.containsKey(s[i])) answer[i] = i - map[s[i]]!!
            else answer[i] = -1
            map[s[i]] = i
        }
        return answer
    }

    fun solutionR(s: String): IntArray {
        val answer = IntArray(s.length) { -1 } // Initialize all values to -1
        val map = mutableMapOf<Char, Int>()
        for (i in s.indices) {
            val lastIndex = map[s[i]] // Get the last index for the current character
            if (lastIndex != null) {
                answer[i] = i - lastIndex
            }
            map[s[i]] = i // Update the index of the current character
        }
        return answer
    }
}

