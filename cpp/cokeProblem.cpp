#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int coke = 0;
	int received = 0;
	int glass = n;
	while (glass >= a) {
		received = (glass / a) * b;
		glass = received + glass % a;
		coke += received;
	}
    return coke;
}