import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && stack.peek().value < temperatures[i]) {
                res[stack.peek().index] = i - stack.peek().index;
                stack.pop();
            }
            stack.push(new Pair(i, temperatures[i]));
        }
        while (!stack.empty()) {
            res[stack.peek().index] = 0;
            stack.pop();
        }

        return res;
    }

    private record Pair(int index, int value) {
    }
}