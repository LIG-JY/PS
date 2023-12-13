import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public void bojSolution() throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        br.close();

        // 유클리드 호제법
        class EuclideanAlgorithm {

            private int run(int num1, int num2) {
                if (num2 == 0) {
                    return num1;
                }
                return run(num2, num1 % num2);
            }
        }

        EuclideanAlgorithm euclideanAlgorithm = new EuclideanAlgorithm();
        int gcd = euclideanAlgorithm.run(a, b);

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(gcd));
        bw.newLine();
        bw.write(String.valueOf(a * b / gcd));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}