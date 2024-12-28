package kotlin.S9466

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val t = reader.readLine().toInt()
                repeat(t) {
                    val n = reader.readLine().toInt()
                    val choices = IntArray(n + 1)
                    reader.readLine().split(" ").forEachIndexed { index, s -> choices[index + 1] = s.toInt() }

                    val visited = BooleanArray(n + 1)
                    val hasTeam = BooleanArray(n + 1)

                    fun makeCycle(n: Int) {
                        val stack = ArrayDeque<Int>()
                        val m = mutableMapOf<Int, Int>()

                        var cur = n
                        while (!visited[cur]) {
                            visited[cur] = true
                            m[cur] = stack.size
                            stack.addLast(cur)
                            val next = choices[cur]
                            if (m.containsKey(next)) {
                                val index = m[next]!!
                                repeat(stack.size - index) {
                                    hasTeam[stack.removeLast()] = true
                                }
                            }
                            cur = next
                        }
                    }

                    for (i in 1..n) {
                        if (!visited[i]) {
                            makeCycle(i)
                        }
                    }
                    writer.writeLine(hasTeam.filter { !it }.size - 1)
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}