import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val intervals = mutableSetOf<Pair<Int, Int>>()
            val laserLocations = mutableSetOf<Int>()
            val dq = ArrayDeque<Pair<Int, Char>>()
            reader.readLine().forEachIndexed { index, c ->
                when (c) {
                    '(' -> {
                        dq.addLast(index to c)
                    }

                    ')' -> {
                        if (dq.last().first + 1 == index) { // laser
                            laserLocations.add(index)
                            dq.removeLast()
                        } else {
                            intervals.add(dq.last().first to index)
                            dq.removeLast()
                        }
                    }
                }
            }
            val allCoordinate = intervals.flatMap { p ->
                p.toList()
            }.toMutableSet()
            allCoordinate.addAll(laserLocations)
            // coordinate compression
            val compressionMap = mutableMapOf<Int, Int>()
            allCoordinate.sorted().forEachIndexed { index, c ->
                compressionMap[c] = index + 1
            }
            // prefix sum
            val prefixSum = IntArray(compressionMap.size + 1)
            laserLocations.sorted().forEach {
                prefixSum[compressionMap[it]!!] = 1
            }
            for (i in 1 until prefixSum.size) {
                prefixSum[i] += prefixSum[i - 1]
            }
            // calculate result
            var res = 0
            // 구간에 속하는 레이저 개수 누적합
            intervals.forEach { interval ->
                res += (prefixSum[compressionMap[interval.second]!!] - prefixSum[compressionMap[interval.first]!! - 1])
            }
            // 끝 막대 추가로 더하기
            res += intervals.size
            writer.writeLine(res)
        }
    }
}

private fun BufferedWriter.writeLine(value: Int) {
    this.write(value.toString())
    this.newLine()
}
