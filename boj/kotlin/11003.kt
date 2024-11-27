import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.collections.ArrayDeque

data class Node(
    val index: Int,
    val value: Int
)

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val tokenizer = StringTokenizer(readLine())

    val dq = ArrayDeque<Node>(l)
    for (i in 0 until n) {
        val inputValue = tokenizer.nextToken().toInt()

        val start = maxOf(i - l + 1, 0)
        // 윈도우에서 벗어난 값 제거
        if (dq.isNotEmpty() && dq.first().index < start) {
            dq.removeFirst()
        }
        // 덱의 첫번째 값은 윈도우의 최소값, 새로 추가된 값보다 큰 값은 최소값을 구할 때 필요없기 때문에 덱에서 제거, 윈도우에서 볼 필요 없음
        while (dq.isNotEmpty() && dq.last().value > inputValue) {
            dq.removeLast()
        }
        // 덱에 새로운 값 추가, 윈도우 옮기기
        dq.addLast(Node(i, inputValue))
        // 최소값 출력
        writer.write("${dq.first().value} ")
    }
    writer.flush()
    writer.close()
}
