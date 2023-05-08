package lv1;

import java.util.Collections;
import java.util.LinkedList;

public class HallOfFame1J {
    public int[] solution(int k, int[] score) {
        FameListJ famelist = new FameListJ(k);
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            answer[i] = famelist.push(score[i]);
        }
        return answer;
    }
}

class FameListJ {
    private final int maxSize;
    private final LinkedList<Integer> scores = new LinkedList<>();

    FameListJ(int maxSize) {
        this.maxSize = maxSize;
    }

    int push(int score) {
        if (isFull()) {
            if (scores.getFirst() < score) scores.removeFirst();
            else return scores.getFirst();
        }
        scores.add(score);
        Collections.sort(scores);
        return scores.getFirst();
    }

    private boolean isFull() {
        return scores.size() == this.maxSize;
    }
}



