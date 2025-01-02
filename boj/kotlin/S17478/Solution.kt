package kotlin.S17478

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val input = reader.readLine().toInt()

                val question = "\"재귀함수가 뭔가요?\""

                val answers = listOf(
                    "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
                    "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
                    "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
                )

                fun answerRecursive(depth: Int, maxDepth: Int) {
                    val indent = "_".repeat(4 * depth)
                    val sb = StringBuilder()
                    if (depth < maxDepth) {
                        sb.append(indent).append(question).append(System.lineSeparator())
                        answers.forEach { sb.append(indent).append(it).append(System.lineSeparator()) }
                        writer.write(sb.toString())
                        answerRecursive(depth + 1, maxDepth)
                    }
                    if (depth == maxDepth) {
                        sb.append(indent).append(question).append(System.lineSeparator())
                        sb.append(indent).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append(System.lineSeparator())
                        writer.write(sb.toString())
                    }
                    writer.writeLine(indent + "라고 답변하였지.")
                }

                fun solve(maxDepth: Int) {
                    writer.writeLine("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.")
                    answerRecursive(0, maxDepth)
                }

                solve(input)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
