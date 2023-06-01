import java.util.LinkedHashMap;
import java.util.Map;

public class boost1 {
    public int[] solution(int[] arr) {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        for (int e : arr) {
            if (!hashMap.containsKey(e)) {
                hashMap.put(e, 1);
            }
            hashMap.put(e, hashMap.get(e) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                count++;
            }
        }
        if (count == 0) {
            return new int[]{-1};
        }
        int[] res = new int[count];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                res[i] = entry.getValue();
                i++;
            }
        }
        return res;
    }
}
