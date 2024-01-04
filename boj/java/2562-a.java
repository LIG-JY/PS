import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public void bojSolution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>(9);
        for (int i = 0; i < 9; i++)  {
            list.add(Integer.parseInt(br.readLine()));
        }

        int max = Collections.max(list);

        bw.write(String.valueOf(max));
        bw.write("\n");
        bw.write(String.valueOf(list.indexOf(max) + 1));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
