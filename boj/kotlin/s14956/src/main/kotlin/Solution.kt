package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }

                data class Point(val y: Int, val x: Int)

                val steps =
                    listOf(Point(Int.MIN_VALUE, Int.MIN_VALUE), Point(1, 1), Point(2, 1), Point(2, 2), Point(1, 2))

                fun solveRecursive(sideLength: Int, stepIndex: Int): Point {
                    assert(stepIndex in 1 until 3)

                    if (sideLength == 2) {
                        return steps[stepIndex]
                    }

                    val half = sideLength / 2
                    val area = half * half

                    if (stepIndex <= area) {
                        val tmp = solveRecursive(half, stepIndex)
                        // y = x 대칭이동
                        val ny = tmp.x
                        val nx = tmp.y

                        return Point(ny, nx)
                    } else if (stepIndex <= 2 * area) {
                        val tmp = solveRecursive(half, stepIndex - area)
                        // y축 half 만큼 평행이동
                        val ny = tmp.y + half
                        val nx = tmp.x

                        return Point(ny, nx)
                    } else if (stepIndex <= 3 * area) {
                        val tmp = solveRecursive(half, stepIndex - 2 * area)
                        // y축 half 만큼 평행이동, x축 half 만큼 평행이동
                        val ny = tmp.y + half
                        val nx = tmp.x + half

                        return Point(ny, nx)
                    } else {
                        val tmp = solveRecursive(half, stepIndex - 3 * area)
                        // x축 half 만큼 평행이동
                        // y + x = half + 1 대칭이동
                        val ny = (half + 1 - tmp.x)
                        val nx = (half + 1 - tmp.y) + half

                        return Point(ny, nx)
                    }
                }

                val result = solveRecursive(n, m)
                writer.writeLine("${result.x} ${result.y}")
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
