import com.g2s.Solution1
import com.g2s.Solution2
import com.g2s.Solution3
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @Test
    fun test1() {
        val input = "15 17\n" +
                "9 -2 2 -2 1 -3 5 -3 -4 1 0 -9 0 7 1"
        val expectedOutput = "328"

        test(Solution1::main, input, expectedOutput)
        test(Solution2::main, input, expectedOutput)
        test(Solution3::main, input, expectedOutput)
    }

    @Test
    fun test2() {
        val input = "19 6\n" +
                "-8 2 -8 -8 -7 -8 -5 2 1 4 5 7 -6 7 4 8 -3 -5 -4"
        val expectedOutput = "6921"

        test(Solution1::main, input, expectedOutput)
        test(Solution2::main, input, expectedOutput)
        test(Solution3::main, input, expectedOutput)
    }

    @Test
    fun test3() {
        val input = "4 0\n" +
                "-1 1 -2 2"
        val expectedOutput = "3"

        test(Solution1::main, input, expectedOutput)
        test(Solution2::main, input, expectedOutput)
        test(Solution3::main, input, expectedOutput)
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