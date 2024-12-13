package kotlin.S16933

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.collections.ArrayDeque

/*
* Kotlin 으로 풀면 불리함
* */
class S16033 {
    companion object {
        const val UNVISITED = 0
        const val VISITED = 1
        const val AVAILABLE = 0
        const val WALL = 1

        enum class State(val value: Int) {
            DAY(0),
            NIGHT(1)
        }

        data class Node(val y: Int, val x: Int, val destroyCount: Int, val time: Int, val state: State)

        val dy = intArrayOf(1, -1, 0, 0)    // List<Pair> 보다 성능에 유리
        val dx = intArrayOf(0, 0, 1, -1)
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m, k) = reader.readLine().split(" ").map { it.toInt() }
                val map = Array(n) { IntArray(m) }
                val visit =
                    Array(n) { Array(m) { Array(k + 1) { IntArray(2) { UNVISITED } } } }    // BooleanArary 보다 성능 우세

                for (y in 0 until n) {
                    val row = reader.readLine()
                    for (x in 0 until m) {
                        map[y][x] = row[x] - '0'
                    }
                }   // 직접 IntArray에 mapping 하는 것이 성능에 유리

                val q = ArrayDeque<Node>()
                q.addLast(Node(0, 0, 0, 1, State.DAY))
                visit[0][0][0][0] = 1

                while (q.isNotEmpty()) {
                    val (y, x, destroyCount, time, state) = q.removeFirst()

                    if (y == n - 1 && x == m - 1) {
                        writer.writeLine(time)
                        return
                    }

                    for (dir in 0 until 4) {
                        val ny = y + dy[dir]
                        val nx = x + dx[dir]

                        if (ny >= 0 && ny < n && nx >= 0 && nx < m) {   // 0 until n range 사용하는 것 보다 성능 우세
                            when (map[ny][nx]) {
                                AVAILABLE -> {
                                    val newState = if (state == State.DAY) State.NIGHT else State.DAY
                                    if (visit[ny][nx][destroyCount][newState.value] == UNVISITED) {
                                        visit[ny][nx][destroyCount][newState.value] = VISITED
                                        q.addLast(Node(ny, nx, destroyCount, time + 1, newState))
                                    }
                                }

                                WALL -> {
                                    if (destroyCount < k) {
                                        when (state) {
                                            State.DAY -> {
                                                val newState = State.NIGHT
                                                if (visit[ny][nx][destroyCount + 1][newState.value] == UNVISITED) {
                                                    visit[ny][nx][destroyCount + 1][newState.value] = VISITED
                                                    q.addLast(Node(ny, nx, destroyCount + 1, time + 1, newState))
                                                }
                                            }

                                            State.NIGHT -> {
                                                val newState = State.DAY
                                                if (visit[y][x][destroyCount][newState.value] == UNVISITED) {
                                                    visit[y][x][destroyCount][newState.value] = VISITED
                                                    q.addLast(Node(y, x, destroyCount, time + 1, newState))
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                writer.writeLine(-1)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Int) {
        this.write("$v")
        this.newLine()
    }
}
