package lv2

import kotlin.math.*

class DoubleCircle {
    fun solution(r1: Int, r2: Int): Long {
        return (1..r2).fold(0.0) { sum, i ->
            val maxOfy = floor(sqrt(r2.toDouble().pow(2) - i.toDouble().pow(2)))
            val minOfy = if (i > r1) 0.0 else ceil(sqrt(r1.toDouble().pow(2) - i.toDouble().pow(2)))
            sum + maxOfy - minOfy + 1.0
        }.toLong() * 4
    }
}

