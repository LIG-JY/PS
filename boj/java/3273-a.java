import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public void bojSolution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int res = 0;

        int n = Integer.parseInt(br.readLine());


        int[] nums = new int[2000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(st.nextToken());
            nums[index] = 1;
        }

        int x = Integer.parseInt(br.readLine());
        for (int i = 1; i < (x + 1) / 2; i++) {
            if (nums[i] == 1 && nums[x - i] == 1) {
                res++;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
