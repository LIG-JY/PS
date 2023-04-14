package lv1.roughlymadekeyboard;

import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String, Integer> minKeyMap = makeMinKeyMap(keymap);

        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            answer[i] = 0;
            for (char button : targets[i].toCharArray()) { // String을 향상된 for문(foreach)으로 순회하기, String을 CharArray로 변경 필요
                if (minKeyMap.get(String.valueOf(button)) != null) {
                    answer[i] += minKeyMap.get(String.valueOf(button)); // char -> String
                    continue;
                }
                answer[i] = -1;
                break;
            }
        }
        return answer;
    }

    public HashMap<String, Integer> makeMinKeyMap(String[] keymap) {
        HashMap<String, Integer> minKeyMap = new HashMap<>();
        for (String s : keymap) {
            for (int j = 0; j < s.length(); j++) { // String 순회하고 char -> String 변환하기, j를 사용하기 위해서 for로 순회
                final int finalJ = j;
                minKeyMap.computeIfAbsent(String.valueOf(s.charAt(j)), k -> finalJ + 1); // 람다식에서 외부 변수에 접근할 때 final만 가능

                if (minKeyMap.get(String.valueOf(s.charAt(j))) > j + 1) { // Integer int value비교가 가능하다. AutoUnboxing
                    minKeyMap.put(String.valueOf(s.charAt(j)), j + 1); // put으로 덮어쓰기
                }
            }
        }
        return minKeyMap;
    }
}