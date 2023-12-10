import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public void bojSolution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        Deque<Integer> list = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int last = -1;
        while (!list.isEmpty()) {
            // 젤 위 카드 버리기
            last = list.pollFirst();

            if (!list.isEmpty()) {
                // 젤 위 카드 아래로 옮기기
                list.addLast(list.pollFirst());
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(last));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
