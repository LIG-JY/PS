package problem;    // 백준 제출 시 제거

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        MyDeque<Integer> deque = new MyDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "push_front":
                    deque.pushFront(Integer.parseInt(tokens[1]));
                    break;
                case "push_back":
                    deque.pushBack(Integer.parseInt(tokens[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(String.valueOf(deque.front()));
                        deque.popFront();
                    }
                    bw.write(System.lineSeparator());
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(String.valueOf(deque.back()));
                        deque.popBack();
                    }
                    bw.write(System.lineSeparator());
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size()));
                    bw.write(System.lineSeparator());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                    bw.write(System.lineSeparator());
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(String.valueOf(deque.front()));
                    }
                    bw.write(System.lineSeparator());
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(String.valueOf(deque.back()));
                    }
                    bw.write(System.lineSeparator());
                    break;
                default:
                    assert false : "유효하지 않은 명령어";
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class MyDeque<T> {
        private static final int MAX_SIZE = 100_0005;
        private final T[] storage;
        private int head = MAX_SIZE;
        private int tail = MAX_SIZE;
        private int count = 0;

        @SuppressWarnings("unchecked")  // type erasure, 캐스팅 시 타입 안정성 보장 X
        public MyDeque() {
            storage = (T[]) new Object[MAX_SIZE * 2 + 1];
        }

        public void pushFront(T data) {
            assert count < MAX_SIZE * 2 + 1;
            head = (head == 0) ? MAX_SIZE * 2 : head - 1;
            storage[head] = data;
            ++count;
        }

        public void pushBack(T data) {
            assert count < MAX_SIZE * 2 + 1;
            storage[tail] = data;
            tail = (tail == MAX_SIZE * 2) ? 0 : tail + 1;
            ++count;
        }

        public void popFront() {
            assert count > 0;
            head = (head == MAX_SIZE * 2) ? 0 : head + 1;
            --count;
        }

        public void popBack() {
            assert count > 0;
            tail = (tail == 0) ? MAX_SIZE * 2 : tail - 1;
            --count;
        }

        public T front() {
            assert count > 0;
            return storage[head];
        }

        public T back() {
            assert count > 0;
            int index = (tail == 0) ? MAX_SIZE * 2 : tail - 1;
            return storage[index];
        }

        public int size() {
            return count;
        }

        public boolean isEmpty() {
            return count == 0;
        }
    }
}
