import java.util.stream.*;

class Solution {
    public long solution(int price, int money, int count) {
        long sum = LongStream.rangeClosed(1, count)
        .map(i -> i * price)
        .sum();
        
        return Math.max(sum - money, 0);
    }
}
