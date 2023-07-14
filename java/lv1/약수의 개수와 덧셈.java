import java.util.stream.*;
import java.math.*;

class Solution {
    private int countDivisor(int num) {
        int res = 0;
        return IntStream.rangeClosed(1, (int)Math.sqrt(num))
            .filter(i -> num % i == 0)
            .map(i ->(num / i == i)  ? 1 : 2)
            .sum();
    }
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right)
        .map(i -> (countDivisor(i) % 2 == 0 ? i : -i))
        .sum();
    }
}}
