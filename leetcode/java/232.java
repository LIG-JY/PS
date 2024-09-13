import java.util.Stack;

class Solution {
    class MyQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        public void push(int x) {
            while (!stack.empty()) {
                tempStack.push(stack.pop());
            }
            tempStack.push(x);
            while (!tempStack.empty()) {
                stack.push(tempStack.pop());
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.empty();
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