import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 상단 트리
        for (int loop = 1; loop <= n - 1; loop++) {
            for (int space = 1; space <= n - loop; space++) {
                bw.write(" ");
            }
            for (int star = 1; star <= 2 * loop - 1; star++) {
                bw.write("*");
            }
            bw.newLine();
        }

        // 중간 라인
        for (int loop = 1; loop <= 2 * n - 1; loop++) {
            bw.write("*");
        }
        bw.newLine();

        // 하단 트리
        for (int loop = n - 1; loop >= 1; loop--) {
            for (int space = 1; space <= n - loop; space++) {
                bw.write(" ");
            }
            for (int star = 1; star <= 2 * loop - 1; star++) {
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
