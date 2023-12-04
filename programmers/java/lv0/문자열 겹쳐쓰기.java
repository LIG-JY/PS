import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        return IntStream.range(0, my_string.length())
                .mapToObj(index -> (index >= s && index < s + overwrite_string.length())
                        ? overwrite_string.charAt(index - s) : my_string.charAt(index))
                //  Use String Builder
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
