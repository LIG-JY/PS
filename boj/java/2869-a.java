import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


    public void bojSolution() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int minimumRequiredLoc = v - a;
            int ondDayStep = a - b;
            int day = (int) Math.ceil((double) minimumRequiredLoc / ondDayStep);
            day++;

            // 출력
            bw.write(String.valueOf(day));
            bw.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
