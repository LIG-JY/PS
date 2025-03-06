import com.g2s.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Test {
    @Test
    fun test1() {
        val input = "1\n" +
                "3 2\n" +
                "0 0 1\n" +
                "0 1 0"
        val expectedOutput = "1"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test2() {
        val input = "3\n" +
                "10 4\n" +
                "0 1 0 0 1 1 1 1 1 1\n" +
                "0 1 0 1 1 0 1 1 1 1\n" +
                "0 0 0 1 1 1 1 0 1 1\n" +
                "1 1 1 1 1 1 1 1 1 0"
        val expectedOutput = "10"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test3() {
        val input = "1\n" +
                "7 5\n" +
                "0 1 0 0 0 0 0\n" +
                "0 1 0 1 1 1 0\n" +
                "0 1 0 1 0 0 0\n" +
                "0 0 0 1 1 1 1\n" +
                "1 1 1 1 1 0 0"
        val expectedOutput = "16"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test4() {
        val input = "1\n" +
                "4 4\n" +
                "0 1 1 1\n" +
                "0 0 1 1\n" +
                "1 0 1 1\n" +
                "1 1 1 0"
        val expectedOutput = "4"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test5() {
        val input = "5\n" +
                "5 8\n" +
                "0 0 0 0 0\n" +
                "1 1 1 1 0\n" +
                "1 1 1 1 0\n" +
                "0 0 1 1 0\n" +
                "0 1 1 0 0\n" +
                "0 1 1 1 1\n" +
                "0 1 1 1 1\n" +
                "0 0 0 0 0\n"
        val expectedOutput = "11"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test6() {
        val input = "5\n" +
                "6 8\n" +
                "0 0 0 0 0 0\n" +
                "1 1 1 1 1 0\n" +
                "1 1 1 1 1 0\n" +
                "0 0 0 1 1 0\n" +
                "0 1 1 1 0 0\n" +
                "0 1 1 1 1 1\n" +
                "0 1 1 1 1 1\n" +
                "0 0 0 0 0 0"
        val expectedOutput = "14"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test7() {
        val input = "5\n" +
                "7 8\n" +
                "0 0 0 0 0 0 0\n" +
                "1 1 1 1 1 1 0\n" +
                "1 1 1 1 1 1 0\n" +
                "0 0 0 1 1 1 0\n" +
                "0 1 1 1 0 0 0\n" +
                "0 1 1 1 1 1 1\n" +
                "0 1 1 1 1 1 1\n" +
                "0 0 0 0 0 0 0"
        val expectedOutput = "17"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test8() {
        val input = "5\n" +
                "7 8\n" +
                "0 0 0 0 0 0 0\n" +
                "1 1 1 1 1 1 0\n" +
                "1 1 1 1 1 1 0\n" +
                "0 0 0 1 1 1 0\n" +
                "0 1 1 1 0 0 0\n" +
                "0 1 0 1 1 1 1\n" +
                "0 1 1 1 1 1 1\n" +
                "0 0 0 0 0 0 0"
        val expectedOutput = "13"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test9() {
        val input = "5\n" +
                "8 8\n" +
                "0 0 0 0 0 0 0 0\n" +
                "1 1 1 1 1 1 1 0\n" +
                "1 1 1 1 1 1 1 0\n" +
                "0 0 0 0 1 1 1 0\n" +
                "0 1 1 1 1 0 0 0\n" +
                "0 1 1 1 1 1 1 1\n" +
                "0 1 1 1 1 1 1 1\n" +
                "0 0 0 0 0 0 0 0"
        val expectedOutput = "20"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test10() {
        val input = "2\n" +
                "2 6\n" +
                "0 1\n" +
                "1 1\n" +
                "1 0\n" +
                "1 1\n" +
                "0 1\n" +
                "0 0"
        val expectedOutput = "4"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test11() {
        val input = "2\n" +
                "10 2\n" +
                "0 0 1 0 0 1 0 0 1 0\n" +
                "0 0 1 1 0 0 0 0 1 0"
        val expectedOutput = "10"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test12() {
        val input = "2\n" +
                "9 2\n" +
                "0 0 1 1 0 0 1 1 0\n" +
                "0 0 1 0 0 0 1 0 0"
        val expectedOutput = "7"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test13() {
        val input = "1\n" +
                "5 3\n" +
                "0 1 0 0 0\n" +
                "0 1 0 1 0\n" +
                "0 0 0 1 0"
        val expectedOutput = "6"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test14() {
        val input = "1\n" +
                "1 1\n" +
                "0"
        val expectedOutput = "0"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test15() {
        val input = "2\n" +
                "10 2\n" +
                "0 0 1 0 0 1 0 0 1 0\n" +
                "0 0 1 1 0 0 0 0 1 0"
        val expectedOutput = "10"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test16() {
        val input = "1\n" +
                "5 5\n" +
                "0 1 1 0 1\n" +
                "0 0 1 0 1\n" +
                "0 1 0 1 1\n" +
                "0 1 0 1 0\n" +
                "1 1 0 1 0"
        val expectedOutput = "-1"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test17() {
        val input = "2\n" +
                "5 3\n" +
                "0 0 0 0 0\n" +
                "1 0 1 1 0\n" +
                "1 0 1 1 0"
        val expectedOutput = "4"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test18() {
        val input = "5\n" +
                "6 6\n" +
                "0 0 0 0 0 1\n" +
                "0 0 0 1 0 1\n" +
                "0 1 0 0 0 1\n" +
                "0 1 0 0 1 0\n" +
                "0 0 0 0 0 1\n" +
                "1 0 0 0 1 0"
        val expectedOutput = "4"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test19() {
        val input = "1\n" +
                "4 4\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 1 1\n" +
                "0 0 1 0"
        val expectedOutput = "4"

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
