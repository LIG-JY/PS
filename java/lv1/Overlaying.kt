package lv1

class Overlaying {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        val wall = IntArray(n) { 0 }
        val arr = IntArray(10) {(it + 1) * 2 }
        section.forEach { wall[it - 1] = 1 }
        var answer = 0
        wall.indices.forEach { i ->
            if (wall[i] == 1) {
                var j = 0
                while (j < m && i + j < wall.size) {
                    if (wall[i + j] == 1) wall[i + j] = 0
                    j++
                }
                answer++
            }
        }
        return answer
    }
}

fun solution2(n: Int, m: Int, section: IntArray): Int {
    var answer = 0
    var nextSection = 0
    section.forEach {
        if (it >= nextSection) {
            answer++
            nextSection = it + m
        }
    }
    return answer
}