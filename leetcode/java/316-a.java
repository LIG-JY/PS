import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {

    public String removeDuplicateLetters(String s) {
        int ASCII = 26;
        int[] map = new int[ASCII];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        Set<Character> inStack = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            map[c - 'a']--;
            if (inStack.contains(c)) {
                continue;
            }
            while (!stack.empty() && stack.peek() > c && map[stack.peek() - 'a'] > 0) {
                inStack.remove(stack.pop());
            }
            stack.push(c);
            inStack.add(c);
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }

    // 순회
    // stack에 오름차순으로 문자 저장
    // 뒤에 문자가 남아있으면 스택에서 문자를 제거해서 순서를 변경할 수 있음
}