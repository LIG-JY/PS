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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>(9);
        for (int i = 0; i < 7; i++)  {
            int num = Integer.parseInt(br.readLine());
            // 홀수만 리스트에 추가
            if (num % 2 == 1) {
                list.add(num);
            }
        }



        // 리스트가 비었으면 -1 출력
        if (list.isEmpty()) {
            bw.write("-1");
        }
        else {
            int sum = list.stream().reduce(0, Integer::sum);
            int min = Collections.min(list);
            bw.write(String.valueOf(sum));
            bw.write("\n");
            bw.write(String.valueOf(min));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
