import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] num_list) {
        String oddNums = Arrays.stream(num_list)
                .filter(num -> num % 2 == 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        String evenNums = Arrays.stream(num_list)
                .filter(num -> num % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        return Integer.parseInt(oddNums) + Integer.parseInt(evenNums);
    }
}
