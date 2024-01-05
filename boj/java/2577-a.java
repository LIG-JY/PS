import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int res = 1;
        for (int i = 0; i < 3; i++)  {
            res *= Integer.parseInt(br.readLine());
        }

        String stringRes = String.valueOf(res);

        int [] cnt = new int[10];

        for (int i = 0; i < stringRes.length(); i++) {
            cnt[stringRes.charAt(i) - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            bw.write(cnt[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
