package com.g2s

class Solution {
    fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val deque = ArrayDeque((1..n).toList())
        val targets = readLine().split(" ").map { it.toInt() }

        var res = 0

        targets.forEach {
            val index = deque.indexOf(it)
            val leftMoves = index
            val rightMoves = deque.size - index

            res += minOf(leftMoves, rightMoves)

            if (leftMoves > rightMoves) {
                repeat(rightMoves) { deque.addFirst(deque.removeLast()) }
            } else {
                repeat(leftMoves) { deque.addLast(deque.removeFirst()) }
            }
            deque.removeFirst()
        }
        println(res)
    }
}
