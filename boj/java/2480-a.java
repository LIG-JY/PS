import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> diceEyes = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            diceEyes.add(Integer.parseInt(st.nextToken()));
        }

        // 오름차순 정렬
        Collections.sort(diceEyes);

        // 3개 같은 경우
        if (diceEyes.get(0) == diceEyes.get(2)) {
            bw.write(String.valueOf(10000 + diceEyes.get(0) * 1000));
        }
        // 2개가 같은 경우
        else if (diceEyes.get(0) == diceEyes.get(1) || diceEyes.get(1) == diceEyes.get(2)) {
            bw.write(String.valueOf(1000 + diceEyes.get(1) * 100));
        }
        // 모두 다른 경우
        else {
            bw.write(String.valueOf(diceEyes.get(2) * 100));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
