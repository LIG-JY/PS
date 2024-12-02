import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val t = reader.readLine().toInt()
            repeat(t) {
                writer.writeLine(getAnswer(reader.readLine()))
            }
        }
    }
}

private fun getAnswer(input: String): String {
    val dq = ArrayDeque<Char>()
    input.forEach {
        when (it) {
            '(' -> {
                dq.addLast(it)
            }

            ')' -> {
                if (dq.isNotEmpty()) {
                    dq.removeLast()
                } else {
                    return "NO"
                }
            }
        }
    }

    return if (dq.isNotEmpty()) {
        "NO"
    } else {
        "YES"
    }
}

private fun BufferedWriter.writeLine(value: String) {
    this.write(value)
    this.newLine()
}
