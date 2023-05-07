package lv1;

import java.util.HashMap;
import java.util.Map;

public class NearestSameLetterJ {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Integer lastIndex = map.get(s.charAt(i));
            answer[i] = lastIndex != null ? i - lastIndex : -1;
            map.put(s.charAt(i), i);
        }
        return answer;
    }
}
