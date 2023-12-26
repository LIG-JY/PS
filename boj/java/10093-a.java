import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public void bojSolution() throws Exception {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        // swap
        if (a.compareTo(b) > 0) {
            BigInteger temp = a;
            a = b;
            b = temp;
        }

        // 예외 처리 a == b
        if (a.compareTo(b) == 0) {
            bw.write("0");
        } else {
            bw.write(b.subtract(a).subtract(BigInteger.ONE) + "\n");
            for (BigInteger i = a.add(BigInteger.ONE); i.compareTo(b) < 0; i = i.add(BigInteger.ONE)) {
                bw.write(i + " ");
            }
        }

        // Print
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
