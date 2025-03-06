import com.g2s.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {

    @Test
    fun test() {
        val input = "5\n" +
                "RRRBB\n" +
                "GGBBB\n" +
                "BBBRR\n" +
                "BBRRR\n" +
                "RRRRR"
        val expectedOutput = "4 3"

        test(input, expectedOutput)
    }

    private fun test(input: String, expectedOutput: String) {
        // Save the original System.in and System.out.
        val originalIn = System.`in`
        val originalOut = System.out

        try {
            // Redirect System.in to simulate input.
            System.setIn(ByteArrayInputStream(input.toByteArray()))
            // Redirect System.out to capture output.
            val outputStream = ByteArrayOutputStream()
            System.setOut(PrintStream(outputStream))

            val solution = Solution()
            solution.main()

            val actualOutput = outputStream.toString().trim()
            assertEquals(expectedOutput, actualOutput)
        } finally {
            // Restore the original System.in and System.out.
            System.setIn(originalIn)
            System.setOut(originalOut)
        }
    }
}