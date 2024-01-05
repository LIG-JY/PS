import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(br.readLine());

        if (year % 4 == 0) {
            if (year % 100 != 0) {
                bw.write("1");
            } else if (year % 400 == 0) {
                bw.write("1");
            } else {
                bw.write("0");
            }
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
