import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Boj1159 {

}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var surrender = true
    val cnt = Array(26) { 0 }
    val n = reader.readLine().toInt()
    repeat(n) {
        val name = reader.readLine()
        cnt[name[0] - 'a']++
    }
    for (i in 0 until 26) {
        if (cnt[i] >= 5) {
            writer.write(('a' + i).toString())
            surrender = false
        }
    }
    if (surrender) {
        writer.write("PREDAJA")
    }
    writer.flush()
    writer.close()
    reader.close()
}