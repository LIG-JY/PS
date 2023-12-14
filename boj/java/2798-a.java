import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private List<Integer> comb = new ArrayList<>();
    private Stack<Integer> buffer = new Stack<>();
    private static final int COMBINATION_SIZE = 3;

    public void bojSolution() throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> cards = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            cards.add(card);
        }
        br.close();

        // 조합
        comb(cards, 0, m, n);

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // comb 각 조합들에서 최대값 구한다.
        bw.write(String.valueOf(Collections.max(comb)));
        bw.newLine();
        bw.flush();
        bw.close();
    }

    // cards 배열, 시작 인덱스, 최대값인 m, n개중 뽑기 위한 totalCount을 매개변수로 받는다.
    private void comb(List<Integer> cards, int start, int blackJack, int totalCount) {

        // 종료 조건 : 3개를 뽑으면 합을 계산한다.
        if (buffer.size() == COMBINATION_SIZE) {

            int combSum = 0;
            for (int card : buffer) {
                combSum += card;
            }
            if (combSum <= blackJack) {
                comb.add(combSum);
            }
            return;
        }

        for (int i = start; i < totalCount; i++) {
            // buffer에 담기
            buffer.add(cards.get(i));
            // 재귀로 조합 호출, 다음 인덱스부터 시작한다.
            comb(cards, i + 1, blackJack, totalCount);
            // buffer에서 가장 마지막에 담은 카드 빼기
            buffer.pop();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
