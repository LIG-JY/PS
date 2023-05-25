package lv1;

public class FoodFightCompetitionsJ {
    public String solution(int[] food) {
        StringBuilder rsb = new StringBuilder();
        StringBuilder lsb;
        for (int i = 1; i < food.length; i++) {
            rsb.append(String.valueOf(i).repeat(Math.max(0, food[i] / 2)));
        }
        lsb = new StringBuilder(rsb);
        lsb.reverse();
        return rsb.append(0).append(lsb).toString();
    }
}
