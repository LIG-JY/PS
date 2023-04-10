package lv1.walkinthepark;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int i;
        int[] start;

        start = findStart(park);
        for (i = 0; i < routes.length; i++) {
            start = move(park, routes[i], start);
        }
        return start;
    }

    public int[] findStart(String[] park) {
        int i;
        int j;
        int[] start = new int[2];
        for (i = 0; i < park.length; i++) {
            for (j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                    return start;
                }
            }
        }
        return start;
    }

    public static int[] move(String[] park, String route, int[] start) {
        String[] routeArr = route.split(" ");
        int q = Integer.parseInt(routeArr[1]);
        int col = start[0];
        int row = start[1];


        switch (routeArr[0]) {
            case "N":
                while (q > 0) {
                    if (col - 1 >= 0) {
                        if (park[col - 1].charAt(row) != 'X') {
                            col--;
                        } else {
                            col = start[0];
                            break;
                        }
                        q--;
                    } else {
                        col = start[0];
                        break;
                    }
                }
                break;
            case "S":
                while (q > 0) {
                    if (col + 1 < park.length) {
                        if (park[col + 1].charAt(row) != 'X') {
                            col++;
                        } else {
                            col = start[0];
                            break;
                        }
                        q--;
                    } else {
                        col = start[0];
                        break;
                    }
                }
                break;
            case "E":
                while (q > 0) {
                    if (row + 1 < park[0].length()) {
                        if (park[col].charAt(row + 1) != 'X') {
                            row++;
                        } else {
                            row = start[1];
                            break;
                        }
                        q--;
                    } else {
                        row = start[1];
                        break;
                    }
                }
                break;
            default:
                while (q > 0) {
                    if (row - 1 >= 0) {
                        if (park[col].charAt(row - 1) != 'X') {
                            row--;
                        } else {
                            row = start[1];
                            break;
                        }
                        q--;
                    } else {
                        row = start[1];
                        break;
                    }
                }
                break;
        }
        return new int[]{col, row};
    }
}

