import java.io.*;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Pair> stack = new Stack<>();
        long res = 0L;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            int count = 1;
            while (!stack.empty() && stack.peek().h <= height) {
                res += stack.peek().c;
                if (stack.peek().h == height) {
                    count += stack.peek().c;
                }
                stack.pop();
            }
            if (!stack.empty()) {
                ++res;
            }
            stack.push(new Pair(height, count));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(res));
        bw.flush();
        br.close();
        bw.close();
    }

    private static class Pair {
        private final int h;
        private final int c;

        private Pair(int h, int c) {
            this.h = h;
            this.c = c;
        }
    }
}