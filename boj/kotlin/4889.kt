import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            var loop = 0
            while (true) {
                ++loop
                val input = reader.readLine()
                if (input[0] == '-') {
                    break
                }
                var res = 0
                val dq = ArrayDeque<Char>()
                input.forEach {
                    when (it) {
                        '{' -> {
                            dq.addLast(it)
                        }

                        '}' -> {
                            if (dq.isEmpty()) {
                                ++res
                                dq.addLast('{')
                            } else {
                                dq.removeLast()
                            }
                        }
                    }
                }
                res += dq.size / 2
                writer.writeLine("$loop. $res")
            }
        }
    }
}

private fun BufferedWriter.writeLine(value: String) {
    this.write(value)
    this.newLine()
}
