import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {

    public String removeDuplicateLetters(String s) {
        int ASCII = 26;
        int[] lastIndex = new int[ASCII];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        Set<Character> inStack = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inStack.contains(c)) {
                continue;
            }
            while (!stack.empty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
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
