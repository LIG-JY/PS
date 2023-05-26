package lv1;

public class CokeIssues {
    public int solution(int a, int b, int n) {
        int received;
        int glass = n;
        int coke = 0;
        while (glass >= a) {
            received = (glass / a) * b;
            coke += received;
            glass = received + glass % a;
        }
        return coke;
    }
}
