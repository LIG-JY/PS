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

        // 상단 공백 역 삼각형
        for (int i = 1; i <= n - 1; i++) {
            printStar(i, bw);
            printSpace(2 * (n - i), bw);
            printStar(i, bw);
            bw.write("\n");
        }
        // 중간 줄
        printStar(2 * n, bw);
        bw.write("\n");
        // 하단 공백 삼각형
        for (int i = 1; i <= n - 1; i++) {
            printStar(n - i, bw);
            printSpace(2 * i, bw);
            printStar(n - i, bw);
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
