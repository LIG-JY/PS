import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(String str1, String str2) {
        // str1.length == str2.length
        return IntStream.range(0, str1.length())
                .mapToObj(i -> String.valueOf(str1.charAt(i)) + str2.charAt(i))
                .collect(Collectors.joining(""));
    }
}
