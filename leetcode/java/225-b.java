import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class MyStack {
        private final Queue<Integer> queue;

        public MyStack() {
            this.queue = new LinkedList<>();
        }

        public void push(int x) {
            this.queue.add(x);
            for (int i = 0; i < queue.size() - 1; ++i) {
                this.queue.add(this.queue.remove());
            }
        }

        public int pop() {
            return this.queue.remove();
        }

        public int top() {
            return this.queue.element();
        }

        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}