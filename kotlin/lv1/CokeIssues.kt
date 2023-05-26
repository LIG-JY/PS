package lv1

class CokeIssues {
    fun solution(a: Int, b: Int, n: Int): Int {
        var coke = 0;
        var received = 0;
        var glass = n;
        while (glass >= a) {
            received = (glass / a) * b;
            glass = received + (glass % a);
            coke += received;
        }
        return coke;
    }
}