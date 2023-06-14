import java.io.*

class Boj2309_a {

}

val fake = ArrayList<Int>()
fun findFake(dwarfs: ArrayList<Int>, sum: Int) {
    for (i in 0 until 9) {
        for (j in i + 1 until 9) {
            if (sum - dwarfs[i] - dwarfs[j] == 100) {
                fake.add(dwarfs[j])
                fake.add(dwarfs[i])
                return
            }
        }
    }
}

fun a() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var sum = 0
    val dwarfs = ArrayList<Int>()

    repeat(9) {
        val num = br.readLine().toInt();
        sum += num
        dwarfs.add(num)
    }
    dwarfs.sort()
    findFake(dwarfs, sum)
    for (e in dwarfs) {
        if (e in fake) {
            continue
        }
        bw.write(e.toString())
        bw.newLine()
    }
    bw.flush()
    bw.close()
    br.close()
}

fun main() {
    a()
}