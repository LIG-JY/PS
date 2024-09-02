import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!map.get(top).equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

/*
 *   20. Valid Parentheses
 *   Runtime: 2ms Beats 52.18%
 *   Memory: 41.38MB Beats 71.00%
 * */