package lv1.organizeyourdesktop;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] wallpaper) {
        int i;
        int j;
        int miny;
        int minx;
        int maxy;
        int maxx;

        PriorityQueue<Integer> minX = new PriorityQueue<>();
        PriorityQueue<Integer> maxX = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minY = new PriorityQueue<>();
        PriorityQueue<Integer> maxY = new PriorityQueue<>(Comparator.reverseOrder());

        for (i = 0; i < wallpaper.length ; i++) {
            for (j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    maxY.add(i);
                    minY.add(i);
                    maxX.add(j);
                    minX.add(j);
                }
            }
        }
        miny = minY.peek() != null ? minY.peek() : 0;
        minx = minX.peek() != null ? minX.peek() : 0;
        maxy = maxY.peek() != null ? maxY.peek() : 0;
        maxx = maxX.peek() != null ? maxX.peek() : 0;
        return new int[] {miny, minx, maxy + 1, maxx + 1};
    }
}