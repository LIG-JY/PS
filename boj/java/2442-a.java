import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n - 1 - i; j++) {
                bw.write(" ");
            }
            for (; j < (n - 1 - i) + (2 * i + 1); j++) {
                bw.write("*");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
