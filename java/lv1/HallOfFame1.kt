package lv1

import java.util.LinkedList

class HallOfFame1 {
    fun solution(k: Int, score: IntArray): IntArray {
        val hallOfFame = FameList(k)
        return score.map { hallOfFame.push(it) }.toIntArray()
    }
}

class FameList(
    private val k: Int
) {
    private val scores: MutableList<Int> = LinkedList()

    fun push(score: Int): Int {
        if (isFull()) {
            if (scores.first() < score) scores.removeFirst()
            else return scores.first()
        }
        scores.add(score)
        scores.sort()
        return scores.first()
    }

    private fun isFull() = scores.size == k
}