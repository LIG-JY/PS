import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public void bojSolution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        int n = Integer.parseInt(br.readLine());
        br.close();

        // 분해합 생성자를 저장하는 컨테이너
        List<Integer> container = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            int res = i;
            int div = res;
            while (div > 0) {
                res += (div % 10);
                div /= 10;
            }
            if (res == n) {
                container.add(i);
            }
        }

        // 최소값 찾기
        int answer = 0;
        if (!container.isEmpty()) {
            answer = Collections.min(container);
        }

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
