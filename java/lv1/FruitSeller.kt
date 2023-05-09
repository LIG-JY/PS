package lv1

import java.util.LinkedList

class FruitSeller {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        score.sortDescending()
        val box = Box(m)
        for (i in 0 until score.size - (score.size % m) step m) {
            for (j in i until i + m) {
                box.pushApple(score[j])
            }
        }
        return box.getPrice()
    }
}

class Box(val size: Int) {
    private val box: MutableList<Int> = LinkedList()
    private var totalPrice = 0

    fun pushApple(appleScore: Int) {
        box.add(appleScore)
        if (box.size == size) {
            this.totalPrice += calculatePrice()
            box.clear()
        }
    }

    private fun calculatePrice(): Int {
        val minVal = box.minOrNull() ?: 0
        return minVal * size
    }

    fun getPrice(): Int = this.totalPrice
}

fun main() {
    println(FruitSeller().solution(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1)))
}