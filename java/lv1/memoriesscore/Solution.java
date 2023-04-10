package lv1.memoriesscore;

import java.util.HashMap;

public class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        int i;
        int j;
        int k;
        int sum;

        HashMap<String, Integer> nameYearning = new HashMap<>();
        for (i = 0; i < name.length; i++){
            nameYearning.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for (j = 0; j < photo.length; j++){
            sum = 0;
            for (k = 0; k < photo[j].length; k++) {
                if (nameYearning.get(photo[j][k]) != null){
                    sum += nameYearning.get(photo[j][k]);
                }
            }
            answer[j] = sum;
        }
        return answer;
    }
}
