import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int point = Integer.parseInt(br.readLine());

        if (point >= 90) {
            bw.write("A");
        } else if (point >= 80) {
            bw.write("B");
        } else if (point >= 70) {
            bw.write("C");
        } else if (point >= 60) {
            bw.write("D");
        } else {
            bw.write("F");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
