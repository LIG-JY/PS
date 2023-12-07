import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        long mul = Arrays.stream(num_list)
                .asLongStream()
                .reduce(1, (a, b) -> a * b);
        long sum = Arrays.stream(num_list)
                .asLongStream()
                .sum();
        return (mul > (sum * sum)) ? 0 : 1;
    }
}
