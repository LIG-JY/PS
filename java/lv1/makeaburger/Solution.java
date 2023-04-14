package lv1.makeaburger;

import java.util.LinkedList;

class Solution {
    public static int answer;

    public int solution(int[] ingredient) {
        LinkedList<Integer> desk = new LinkedList<>();
        Solution.answer = 0;
        for (int e : ingredient) {
            desk.add(e);
            if (desk.size() > 3) {
                if ((desk.get(desk.size() - 1) == 1)
                        && (desk.get(desk.size() - 2) == 3)
                        && (desk.get(desk.size() - 3) == 2)
                        && (desk.get(desk.size() - 4) == 1)) {
                    Solution.answer++;
                    int offset = desk.size() - 4;
                    while (desk.size() > offset) {
                        desk.removeLast();
                    }
                }
            }
        }
        return Solution.answer;
    }
}
