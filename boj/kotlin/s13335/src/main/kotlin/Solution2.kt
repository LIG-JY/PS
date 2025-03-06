package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution2 {
    companion object {
        fun main() {
            BufferedReader(InputStreamReader(System.`in`)).use { reader ->
                BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                    val (n, w, l) = reader.readLine().split(" ").map { it.toInt() }
                    val weights = reader.readLine().trim().split(" ").map { it.toInt() }
                    assert(weights.size == n)

                    val truckEntryTime = IntArray(n)
                    val inBridge = ArrayDeque<Int>(n)
                    inBridge.addLast(0)
                    truckEntryTime[0] = 1

                    var weightSum = weights[inBridge.first()]
                    var latestOut = -1
                    for (i in 1 until n) {
                        val nextWeight = weights[i]
                        while (weightSum + nextWeight > l || inBridge.size > w) {
                            latestOut = inBridge.removeFirst()
                            weightSum -= weights[latestOut]
                        }
                        inBridge.addLast(i)
                        weightSum += weights[i]
                        if (inBridge.first() == 0) {
                            truckEntryTime[i] = truckEntryTime[i - 1] + 1
                        } else {
                            truckEntryTime[i] = maxOf(truckEntryTime[i - 1] + 1, truckEntryTime[latestOut] + w)
                        }
                    }

                    writer.writeLine(truckEntryTime[n - 1] + w)
                }
            }
        }

        private fun BufferedWriter.writeLine(v: Any) {
            this.write("$v")
            this.newLine()
        }
    }
}
