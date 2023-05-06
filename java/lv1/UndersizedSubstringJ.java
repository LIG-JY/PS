package lv1;

import java.math.BigInteger;

public class UndersizedSubstringJ {

    public static int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            if (new BigInteger(t.substring(i, i + p.length())).compareTo(new BigInteger(p)) <= 0)
                answer++;
        }
        return answer;
    }
}