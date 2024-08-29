import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            var input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            if (N == 0) {
                break;
            }
            long result = 0L;
            Stack<Pair> stack = new Stack<>();
            for (int i = 1; i <= N; i++) {
                int currentHeight = Integer.parseInt(input[i]);
                int currentIndex = i;
                while (!stack.empty() && stack.peek().height >= currentHeight) {
                    result = Long.max(result, (long) (i - stack.peek().index) * stack.peek().height);
                    currentIndex = stack.peek().index;
                    stack.pop();
                }
                stack.push(new Pair(currentHeight, currentIndex));
            }
            while (!stack.empty()) {
                result = Long.max(result, (long) (N + 1 - stack.peek().index) * stack.peek().height);
                stack.pop();
            }
            bw.write(result + System.lineSeparator());
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static class Pair {
        private int height;
        private int index;

        private Pair(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}