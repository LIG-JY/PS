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
                "29 5\n" +
                "*.*.*\n" +
                "*A*a*\n" +
                "*b*B*\n" +
                "*C*c*\n" +
                "*d*D*\n" +
                "*E*e*\n" +
                "*f*F*\n" +
                "*G*g*\n" +
                "*h*H*\n" +
                "*I*i*\n" +
                "*j*J*\n" +
                "*K*k*\n" +
                "*l*L*\n" +
                "*M*m*\n" +
                "*n*N*\n" +
                "*O*o*\n" +
                "*p*P*\n" +
                "*Q*q*\n" +
                "*r*R*\n" +
                "*S*s*\n" +
                "*t*T*\n" +
                "*U*u*\n" +
                "*v*V*\n" +
                "*W*w*\n" +
                "*x*X*\n" +
                "*Y*y*\n" +
                "*z*Z*\n" +
                "*\$*\$*\n" +
                "*****\n" +
                "0"
        val expectedOutput = "2"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test2() {
        val input = "1\n" +
                "2 2\n" +
                "**\n" +
                "\$a\n" +
                "0"
        val expectedOutput = "1"

        test(Solution::main, input, expectedOutput)
    }

    @Test
    fun test3() {
        val input = "1\n" +
                "3 3\n" +
                "\$*\$\n" +
                "***\n" +
                "\$*\$\n" +
                "0"
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
