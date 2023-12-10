import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    boolean isPrime(int num) {
        List<Boolean> eratos = new ArrayList<>(Collections.nCopies(num + 1, true));

        for (int i = 0; i <= 1; i++) {
            eratos.set(i, false);
        }

        for (int i = 2; i * i <= num; i++) {
            if (eratos.get(i)) {
                for (int j = i * i; j <= num; j += i) {
                    eratos.set(j, false);
                }
            }
        }
        return eratos.get(num);
    }

    public void bojSolution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int result = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            int inputNum = Integer.parseInt(st.nextToken());
            if (isPrime(inputNum)) {
                result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
