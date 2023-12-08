import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] num_list) {

        return Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), list -> {
                            int lastNum = list.get(num_list.length - 1);
                            int prevNum = list.get(num_list.length - 2);
                            list.add(lastNum > prevNum ? lastNum - prevNum : 2 * lastNum);
                            return list;
                        }))
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
