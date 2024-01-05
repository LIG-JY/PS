import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int input = Integer.parseInt(br.readLine());
            sum += input;
            nums[i] = input;
        }

        int avg = sum / 5;
        Arrays.sort(nums);

        bw.write(String.valueOf(avg));
        bw.write("\n");
        bw.write(String.valueOf(nums[2]));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
