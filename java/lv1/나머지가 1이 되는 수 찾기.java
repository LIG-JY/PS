import java.util.stream.*;

class Solution {
    public int solution(int n) {
    return (int) IntStream.rangeClosed(2, n)
            .filter(i -> n % i == 1)
            .findFirst()
            .getAsInt(); // orElse(0);
    }
}
