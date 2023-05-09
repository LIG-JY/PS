import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        sortArrayDescending(score);
        Box box = new Box(m);
        for (int i = 0; i < score.length - (score.length % m); i += m) {
            for (int j = i; j < i + m; j++) {
                box.pushApple(score[j]);
            }
        }
        return box.getPrice();
    }

    private void sortArrayDescending(int[] array) {
        Arrays.sort(array);
        int len = array.length;
        for(int i = 0; i < len / 2; i++) {
            int temp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = temp;
        }
    }
}

class Box {
    private LinkedList<Integer> box = new LinkedList<>();
    private int totalPrice = 0;
    private int size;

    public Box(int size) {
        this.size = size;
    }

    public void pushApple(int appleScore) {
        box.add(appleScore);
        if (box.size() == size) {
            this.totalPrice += calculatePrice();
            box.clear();
        }
    }

    private int calculatePrice() {
        int minVal = box.stream()
                .min(Integer::compareTo)
                .orElse(0);
        return minVal * size;
    }

    public int getPrice() {
        return this.totalPrice;
    }
}
