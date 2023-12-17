import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public void bojSolution() throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int start = n / 5;
        List<Integer> cntList = new ArrayList<>(start + 1);
        for (int i = start; i >= 0; i--) {
            int goal = n - 5 * i;
            if (goal % 3 == 0) {
                cntList.add(i + goal / 3);
            }
        }

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (cntList.isEmpty()) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(Collections.min(cntList)));
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
