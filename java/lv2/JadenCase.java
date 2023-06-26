import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isNextUp = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                sb.append(c);
                isNextUp = true;
            }
            else {
                sb.append(isNextUp ? Character.toUpperCase(c) : Character.toLowerCase(c));
                isNextUp = false;
            }
        }
        return sb.toString();
    }
}
