package lv1

class PasswordForTwo {
    fun solution(s: String, skip: String, index: Int): String {
        val alphabet = ('a'..'z').filterNot { it in skip }
        return (s.map { alphabet[(alphabet.indexOf(it) + index) % alphabet.size] })
            .joinToString("")
    }
}

fun main() {
    println(PasswordForTwo().solution("aukks", "wbqd", 5))
}
