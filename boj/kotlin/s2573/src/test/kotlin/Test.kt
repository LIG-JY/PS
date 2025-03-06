import com.g2s.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @Test
    fun test1() {
        val input = "5 5\n" +
                "0 0 0 0 0\n" +
                "0 3 3 3 0\n" +
                "0 3 2 3 0\n" +
                "0 3 3 3 0\n" +
                "0 0 0 0 0"
        val expectedOutput = "0"

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