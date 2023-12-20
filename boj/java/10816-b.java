import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public void bojSolution() throws Exception {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> card_map = new HashMap<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)  {
            int card = Integer.parseInt(st.nextToken());
            if (card_map.containsKey(card)) {
                card_map.put(card, card_map.get(card) + 1);
            }
            else {
                card_map.put(card, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target= Integer.parseInt(st2.nextToken());
            if (card_map.containsKey(target)) {
                bw.write(String.valueOf(card_map.get(target)));
            }
            else {
                bw.write("0");
            }
            bw.write(" ");
        }

        // flush
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
