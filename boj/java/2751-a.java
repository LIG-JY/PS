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
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            list.add(input);
        }
        br.close();

        // 정렬
        Collections.sort(list);

        // 출력
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (Integer e : list) {
                bufferedWriter.write(String.valueOf(e));
                bufferedWriter.newLine();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
