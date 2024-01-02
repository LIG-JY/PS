import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 상단 별 역 삼각형
        for (int i = 1; i <= n - 1; i++) {
            printSpace(i - 1, bw);
            printStar(2 * (n - i) + 1, bw);
            bw.write("\n");
        }
        // 중간 별
        printSpace(n - 1, bw);
        printStar(1, bw);
        bw.write("\n");
        // 하단 별 삼각형
        for (int i = 1; i <= n - 1; i++) {
            printSpace(n - 1 - i, bw);
            printStar(2 * i + 1, bw);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private void printStar(int count, BufferedWriter bw) throws IOException {
        for (int i = 0; i < count; i++) {
            bw.write("*");
        }
    }

    private void printSpace(int count, BufferedWriter bw) throws IOException {
        for (int i = 0; i < count; i++) {
            bw.write(" ");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
