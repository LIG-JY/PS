import java.util.Stack;

class Solution {
    class MyQueue {
        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            shiftStack();
            return output.pop();
        }

        public int peek() {
            shiftStack();
            return output.peek();
        }

        public boolean empty() {
            return output.empty() && input.empty();
        }

        private void shiftStack() {
            if (output.empty()) {
                while (!input.empty()) {
                    output.push(input.pop());
                }
            }
        }
    }
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}