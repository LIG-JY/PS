import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static class myStack extends Stack<Integer> {

        private final List<String> outputList = new ArrayList<>();

        @Override
        public Integer push(Integer item) {
            // push 할 때 outputList에 출력값 저장
            this.outputList.add("+");
            return super.push(item);
        }

        @Override
        public Integer pop() {
            // pop 할 때 outputList에 출력값 저장
            this.outputList.add("-");
            return super.pop();
        }

        public void printOutput() {
            outputList.forEach(System.out::println);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> inputsList = new ArrayList<>(n);
        myStack stack = new myStack();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            // 입력값을 담은 리스트
            inputsList.add(Integer.parseInt(br.readLine()));
            // 스택에 순서대로 넣기 위해 큐에 n까지 오름차순으로 저장
            queue.add(i);
        }

        int lastPopped = 0;

        for (Integer input : inputsList) {

            // case 1 : lastPopped 보다 input이 큰 경우
            if (lastPopped < input) {

                if (queue.isEmpty() || queue.peek() > input) {
                    System.out.println("NO");
                    return;
                }

                while (!queue.isEmpty() && queue.peek() <= input) {
                    stack.push(queue.poll());
                }

                // stack에서 제거
                // lastPopped 갱신
                lastPopped = stack.pop();
            }
            // case 2 : lastPopped 보다 input이 작은 경우
            else {

                // stack에서 못 찾는 경우
                if (stack.isEmpty() || stack.peek() < input) {
                    System.out.println("NO");
                    return;
                }

                // 최소 1번은 수행한다. stack.peek() > input을 만족하기 때문
                int stackPeekVal;
                do {
                    stackPeekVal = stack.peek();

                    // stack에서 못 찾는 경우(값이 건너 뛰는 경우)
                    if (stackPeekVal < input) {
                        System.out.println("NO");
                        return;
                    }

                    // stack에서 제거
                    // lastPopped 갱신
                    lastPopped = stack.pop();
                }
                while (!stack.isEmpty() && stackPeekVal > input);
            }
        }
        stack.printOutput();
    }
}

