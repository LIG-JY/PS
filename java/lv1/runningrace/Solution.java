package lv1.runningrace;

import java.util.HashMap;
import java.util.TreeMap;


class Solution {

    public String[] solution(String[] players, String[] callings) {
        int i = 0;
        int rank;
        String prevPlayer;
        String[] answer = new String[players.length];

        HashMap<String, Integer> nameToRank = new HashMap<>();  // HashMap을 사용한 이유
        TreeMap<Integer, String> rankToName = new TreeMap<>();  // Rank 순서로 정렬이 필요하다. TreeMap을 사용한 이유
        for (String player : players) {
            nameToRank.put(player, i);
            rankToName.put(i++, player);
        }
        for (String called : callings) {
            rank = nameToRank.get(called);
            prevPlayer = rankToName.get(rank - 1);
            nameToRank.put(called, rank - 1);
            nameToRank.put(prevPlayer, rank);
            rankToName.put(rank, prevPlayer);
            rankToName.put(rank - 1, called);
        }

        for (i = 0; i < players.length; i++) {
            answer[i] = rankToName.get(i);
        }
        return answer;
    }
}
