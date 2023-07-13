#include <bits/stdc++.h>
using namespace std;

int n, cumsum, cnt;
string input;
bool oFlag;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	string bufferflush;
	getline(cin, bufferflush);
	while (n--) {
		cin >> input;
		cumsum = 0;
		cnt = 0;
		oFlag = false;
		for (char c : input) {
			if (!oFlag && c == 'O') {
				oFlag = true;
				cnt = 1;
			}
			else if (oFlag) {
				if(c == 'X') {
					for (int i = 1; i <= cnt; i++) {
						cumsum += i;
					}
					cnt = 0;
					oFlag = false;
				}
				else {
					cnt++;
				}
			}
		}
		for (int i = 1; i <= cnt; i++) {
				cumsum += i;
			}
		cout << cumsum << "\n";
	}
}