import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();

        // 에라토스테네스의 체
        List<Boolean> eratos = new ArrayList<>(m + 1);
        // 처음에는 m까지 모든 수가 소수라고 가정하기 때문에 true로 채운다.
        for (int i = 0; i <= m; i++) {
            eratos.add(true);
        }
        // 0과 1은 소수가 아니라서 false
        eratos.set(0, false);
        eratos.set(1, false);
        // 2부터 m까지 수에서 소수가 아닌 수는 false로 변경한다.
        for (int i = 2; i * i <= m; i++) {
            if (eratos.get(i)) {
                // i 가 소수면 i * i , i * (i + 1) ..... i의 배수는 모두 소수가 아니다.
                // i * 2 , i * 3 , i * 4.... i * k (k < i) i보다 작은 k가 곱해진 i의 배수는 이미 false
                for (int j = i * i; j <= m; j += i) {
                    eratos.set(j, false);
                }
            }
        }

        // 출력
        for (int i = n; i <= m; i++) {
            if (eratos.get(i)) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
