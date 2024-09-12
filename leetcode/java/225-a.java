class Solution {
    class MyStack {
        private final int[] stack;
        private int top;

        public MyStack() {
            this.stack = new int[128];
            this.top = 0;
        }

        public void push(int x) {
            assert top < stack.length;
            stack[top++] = x;
        }

        public int pop() {
            assert top > 0;
            return stack[--top];
        }

        public int top() {
            assert top > 0;
            return stack[top - 1];
        }

        public boolean empty() {
            return top == 0;
        }
    }
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}