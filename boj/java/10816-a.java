import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public int lower_bound(int[] arr, int target) {
        // Binary Search
        int left = 0;
        int right = arr.length;

        while (left < right) {
            // mid pointer
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public int upper_bound(int[] arr, int target) {
        // Binary Search
        int left = 0;
        int right = arr.length;

        while (left < right) {
            // mid pointer
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public void bojSolution() throws Exception {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)  {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target= Integer.parseInt(st2.nextToken());
            bw.write(String.valueOf(upper_bound(cards, target) - lower_bound(cards, target)));
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
