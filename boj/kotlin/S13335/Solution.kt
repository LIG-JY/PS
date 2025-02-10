package kotlin.S13335

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val EMPTY = 0
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, w, l) = reader.readLine().split(" ").map { it.toInt() }
                val weights = reader.readLine().trim().split(" ").map { it.toInt() }
                assert(weights.size == n)

                val queue = ArrayDeque(weights)
                val bridge = IntArray(w) { EMPTY }

                var weightSum = 0
                var turn = 0
                while (queue.isNotEmpty()) {
                    val next = queue.first()
                    val head = bridge.last()
                    if (weightSum - head + next <= l) {
                        shiftArray(bridge)
                        bridge[0] = queue.removeFirst()
                        weightSum += bridge[0]
                    } else {
                        shiftArray(bridge)
                    }
                    weightSum -= head
                    ++turn
                }

                while (weightSum > 0) {
                    val head = bridge.last()
                    shiftArray(bridge)
                    weightSum -= head
                    ++turn
                }

                writer.writeLine(turn)
            }
        }
    }

    private fun shiftArray(arr: IntArray) {
        for (i in arr.size - 1 downTo 1) {
            arr[i] = arr[i - 1]
        }
        arr[0] = EMPTY
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
