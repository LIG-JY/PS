import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public boolean binarySearch(int [] list, int target) {
        // left
        int l = 0;
        // right
        int r = list.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 찾을 경우
            if (list[mid] == target) {
                return true;
            }
            else if (list[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        // 못 찾을 경우
        return false;
    }

    public void bojSolution() throws Exception {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        // 이진 탐색 하기 위해서 정렬
        Arrays.sort(list);

        // 비교집단 입력
        int m =  Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            // 이진 탐색 후 출력
            if (binarySearch(list, Integer.parseInt(st.nextToken()))) {
                bw.write("1");
            }
            else {
                bw.write("0");
            }
            bw.write("\n");
        }

        // flush
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
