import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val input = reader.readLine()

            val dq = ArrayDeque<Pair<Int, Char>>(input.length)
            val laserLocation = mutableSetOf<Int>()
            val intervals = mutableSetOf<Pair<Int, Int>>()
            input.forEachIndexed { index, char ->
                when (char) {
                    '(' -> {
                        dq.addLast(Pair(index, char))
                    }

                    ')' -> {
                        if (dq.last().first + 1 == index) {
                            laserLocation.add(index)
                        } else {
                            intervals.add(Pair(dq.last().first, index)) //
                        }
                        dq.removeLast()
                    }
                }
            }
            // coordinate compression
            val allCoordinates = intervals.flatMap { p ->
                listOf(p.first, p.second)
            }.toMutableSet()
            allCoordinates.addAll(laserLocation)
            val coordinateMap = allCoordinates.sorted().withIndex().associate { it.value to it.index + 1 }
            val compressedLaserLocation = laserLocation.map { coordinateMap.getValue(it) }
            // prefix sum
            val prefixSum = IntArray(coordinateMap.size + 1)
            compressedLaserLocation.forEach {
                prefixSum[it] = 1
            }
            for (i in 1 until prefixSum.size) {
                prefixSum[i] += prefixSum[i - 1]
            }
            var result = 0
            intervals.forEach { p ->
                val start = coordinateMap[p.first]!! - 1
                val end = coordinateMap[p.second]!!
                result += prefixSum[end] - prefixSum[start] + 1
            }
            writer.writeLine(result.toString())
        }
    }
}

private fun BufferedWriter.writeLine(str: String) {
    write(str)
    this.newLine()
}
