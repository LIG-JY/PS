package kotlin.S16987

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()

                data class Egg(var s: Int, val w: Int)

                val eggs = reader.readLines().map {
                    val (s, w) = it.split(" ").map { part -> part.toInt() }
                    Egg(s, w)
                }

                fun solve(): Int {
                    var max = Int.MIN_VALUE

                    fun solveRecursive(idx: Int) {
                        if (idx == n) {
                            max = maxOf(max, eggs.count { it.s <= 0 })
                            return
                        }

                        val selected = eggs[idx]
                        if (selected.s > 0 && eggs.count { it.s > 0 } > 1) {
                            for (i in 0 until n) {
                                if (i == idx) continue
                                if (eggs[i].s <= 0) continue

                                selected.s -= eggs[i].w
                                eggs[i].s -= selected.w

                                solveRecursive(idx + 1)

                                eggs[i].s += selected.w
                                selected.s += eggs[i].w
                            }
                        } else {
                            solveRecursive(idx + 1)
                        }
                    }

                    solveRecursive(0)

                    return max
                }

                writer.writeLine(solve())
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
