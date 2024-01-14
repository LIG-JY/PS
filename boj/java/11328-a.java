import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public void bojSolution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<String, Integer> cnt = new HashMap<>();
            for (int round = 1; round <= 2; round++){
                String value = st.nextToken();
                for (int i = 0; i < value.length(); i++) {
                    String key = String.valueOf(value.charAt(i));
                    if (round == 1){
                        cnt.put(key, cnt.getOrDefault(key, 0) + 1);
                    }
                    else {
                        cnt.put(key, cnt.getOrDefault(key, 0) - 1);
                    }
                }
            }
            boolean isPossible = true;
            for (String key : cnt.keySet()) {
                if (cnt.get(key) != 0) {
                    isPossible = false;
                    break;
                }
            }
            bw.write(isPossible ? "Possible\n" : "Impossible\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
