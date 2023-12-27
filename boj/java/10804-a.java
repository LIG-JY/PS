import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // cards
        int[] cards = new int[21];
        for (int i = 1; i <= 20; i++) {
            cards[i] = i;
        }

        for (int loop = 0; loop < 10; loop++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lowerBound = Integer.parseInt(st.nextToken());
            int upperBound = Integer.parseInt(st.nextToken());

            // swap
            for (int i = 0; i < (upperBound - lowerBound + 1) / 2; i++) {
                int temp = cards[lowerBound + i];
                cards[lowerBound + i] = cards[upperBound - i];
                cards[upperBound - i] = temp;
            }
        }

        for (int i = 1; i <= 20; i++) {
            bw.write(String.valueOf(cards[i]));
            if (i != 20) {
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
