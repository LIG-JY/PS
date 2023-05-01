package lv2

class Billiards {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        return balls.mapNotNull { ball ->
            var northOk: Boolean = true
            var southOk: Boolean = true
            var westOk: Boolean = true
            var eastOk: Boolean = true

            if (startX == ball[0]) {
                if (startY < ball[1]) northOk = false
                else southOk = false
            }

            if (startY == ball[1]) {
                if (startX < ball[0]) eastOk = false
                else westOk = false
            }

            listOfNotNull(
                if (northOk) intArrayOf(ball[0], n + n - ball[1]) else null,
                if (southOk) intArrayOf(ball[0], -ball[1]) else null,
                if (westOk) intArrayOf(-ball[0], ball[1]) else null,
                if (eastOk) intArrayOf(m + m - ball[0], ball[1]) else null
            ).minOfOrNull { newBall ->
                (newBall[0] - startX) * (newBall[0] - startX) + (newBall[1] - startY) * (newBall[1] - startY)
            }
        }.toIntArray()
    }
}