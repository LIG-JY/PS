import java.util.*;

class Solution {
    public String solution(String s) {
        ArrayList<String> splitted = new ArrayList<>(Arrays.asList(s.split(" ")));
        ArrayList<Long> nums = new ArrayList<>();
        
        for (String num : splitted) {
            nums.add(Long.parseLong(num));
        }
        
        long max_v = Collections.max(nums);
        long min_v = Collections.min(nums);
        
        StringBuilder sb = new StringBuilder();
        sb.append(min_v);
        sb.append(" ");
        sb.append(max_v);
        return sb.toString();
    }
}
