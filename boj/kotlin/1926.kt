import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class Point(val y: Int, val x: Int)

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val (n, m) = reader.readLine().split(" ").map { it.toInt() }
            val visited = Array(n) { BooleanArray(m) }
            val canvas = Array(n) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

            var count = 0
            var maxWidth = 0
            for (y in 0 until n) {
                for (x in 0 until m) {
                    if (canvas[y][x] == 1 && !visited[y][x]) {
                        ++count
                        maxWidth = maxOf(bfs(visited, canvas, Point(y, x)), maxWidth)
                    }
                }
            }
            writer.writeLine(count)
            writer.writeLine(maxWidth)
        }
    }
}

private fun bfs(visited: Array<BooleanArray>, canvas: Array<IntArray>, location: Point): Int {
    val directions = listOf(Point(1, 0), Point(-1, 0), Point(0, 1), Point(0, -1))
    val dq = ArrayDeque<Point>()

    var size = 0
    visited[location.y][location.x] = true
    dq.addLast(location)
    while (dq.isNotEmpty()) {
        val current = dq.removeFirst()
        size++
        for (d in directions) {
            val ny = current.y + d.y
            val nx = current.x + d.x
            if (ny < 0 || nx < 0 || ny >= canvas.size || nx >= canvas[0].size) {
                continue
            }
            if (canvas[ny][nx] == 1 && !visited[ny][nx]) {
                visited[ny][nx] = true
                dq.addLast(Point(ny, nx))
            }
        }
    }
    return size
}

private fun BufferedWriter.writeLine(value: Int) {
    this.write(value.toString())
    this.newLine()
}
