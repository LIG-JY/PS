import com.g2s.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @Test
    fun test1() {
        val input = "5 10 4\n" +
                "1 2 1 2\n" +
                "1........2\n" +
                ".....44...\n" +
                "......4...\n" +
                "2.........\n" +
                "....3....."
        val expectedOutput = "5 21 4 20"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test2() {
        val input = "5 5 2\n" +
                "1 1\n" +
                "1....\n" +
                ".###.\n" +
                ".#.#.\n" +
                ".###.\n" +
                "....2"
        val expectedOutput = "9 7"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test3() {
        val input = "4 4 2\n" +
                "2 1\n" +
                "1..1\n" +
                "....\n" +
                "....\n" +
                "...2\n"
        val expectedOutput = "14 2"

        test(Solution::main, input, expectedOutput)
    }

    private fun test(main: () -> Unit, input: String, expectedOutput: String) {
        // Save the original System.in and System.out.
        val originalIn = System.`in`
        val originalOut = System.out

        try {
            // Redirect System.in to simulate input.
            System.setIn(ByteArrayInputStream(input.toByteArray()))
            // Redirect System.out to capture output.
            val outputStream = ByteArrayOutputStream()
            System.setOut(PrintStream(outputStream))

            main()

            val actualOutput = outputStream.toString().trim()
            assertEquals(expectedOutput, actualOutput)
        } finally {
            // Restore the original System.in and System.out.
            System.setIn(originalIn)
            System.setOut(originalOut)
        }
    }
}
