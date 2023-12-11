import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> res = new ArrayList<>();
        for (var query : queries) {
            res.add(runQuery(arr ,query));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int runQuery(int[] arr, int[] query) {
        List<Integer> resultSet = new ArrayList<>();
        for (int i = query[0]; i <= query[1] ; i++) {
            if (arr[i] > query[2]) {
                resultSet.add(arr[i]);
            }
        }
        if (!resultSet.isEmpty()) {
            return Collections.min(resultSet);
        }
        return -1;
    }
}
