import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(String my_string, int k) {
        return IntStream.range(0, k)
                .mapToObj(i -> my_string)
                .collect(Collectors.joining());
        
    //        return my_string.repeat(k);
    }
}
