public class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(e -> (n % 2 == 0) ? e % 2 == 0 : e % 2 == 1)
                .map(e -> (n % 2 == 0) ? e * e : e)
                .sum();

//        // solution 2
//        if (n % 2 == 0) {
//            return IntStream.rangeClosed(1, n)
//                    .filter(e -> e % 2 == 0)
//                    .mapToObj(e -> e * e)
//                    .reduce(0, Integer::sum);
//        }
//        else {
//            return IntStream.rangeClosed(1, n)
//                    .filter(e -> e % 2 == 1)
//                    .reduce(0, Integer::sum);
//        }
//
    }
}

