#include <bits/stdc++.h>
using namespace std;

int A, B, C;
int t[101];
int arrival, departure;
int res;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> A >> B >> C;
	for (int i = 0; i < 3 ; i++) {
		cin >> arrival >> departure;
		for (int i = arrival; i < departure; i++) {
			t[i] += 1;
		}
	}
	for (auto e : t) {
		switch (e) {
			case 1:
			res += A;
			break;
			case 2:
			res += B*2;
			break;
			case 3:
			res += C*3;
			break;
		}
	}
	cout << res;
    return 0;
}