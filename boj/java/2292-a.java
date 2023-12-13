import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public void bojSolution() throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (n == 1) {
            bw.write(String.valueOf(1));
        } else {
            int last_bound = 1;
            int answer = 1;
            boolean isOutOfBound = true;
            while (isOutOfBound) {
                if (n > last_bound && n <= last_bound + 6 * answer) {
                    isOutOfBound = false;
                }
                last_bound += 6 * answer;
                answer++;
            }
            bw.write(String.valueOf(answer));
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
