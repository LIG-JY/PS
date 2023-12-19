import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static private class Triangle {
        private final int x;
        private final int y;
        private final int z;

        private Triangle(int x, int y, int z) {
            List<Integer> temp = new ArrayList<>(List.of(x, y, z));
            Collections.sort(temp);
            this.x = temp.get(0);
            this.y = temp.get(1);
            this.z = temp.get(2);
        }

        private boolean isRightTriangle() {
            return (x * x + y * y == z * z);
        }

        private boolean isLast() {
            return (x == 0 && y == 0 && z == 0);
        }
    }

    public void bojSolution() throws Exception {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            Triangle triangle = new Triangle(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            if (triangle.isLast()) {
                br.close();
                break;
            }

            if (triangle.isRightTriangle()) {
                bw.write("right\n");
            }
            else {
                bw.write("wrong\n");
            }
        }

        // flush
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
