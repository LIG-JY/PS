import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0L;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!stack.empty() && stack.peek() <= h) {
                stack.pop();
            }
            result += stack.size();
            stack.push(h);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
