#include <bits/stdc++.h>
using namespace std;

int n,x,res;
string input;
vector<int> cnt;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	string bufferflush;
	getline(cin, bufferflush);
	while (n--) {
		cin >> input;
		res = 0;
		x = 0;
		for (char c : input) {
			if (c == 'O') {
				x++;
				cnt.push_back(x);
			}
			else {
				x = 0;
				while (!cnt.empty()) {
					res += cnt.back();
					cnt.pop_back();
				}
			}
		}
		while (!cnt.empty()) {
			res += cnt.back();
			cnt.pop_back();
		}
		cout << res << "\n";
	}
}