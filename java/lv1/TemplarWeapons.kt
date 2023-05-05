package lv1


class TemplarWeapons {
    fun solution(number: Int, limit: Int, power: Int): Int {
        return (1..number).sumOf {
            if (countDivisors(it) > limit) power
            else countDivisors(it)
        }
    }

    private fun countDivisors(number: Int): Int {
        var count = 0
        var i = 1
        while (i * i < number) {
            if (number % i == 0) {
                count += 2
            }
            i++
        }
        if (i * i == number) count++
        return count
    }
}