#include <bits/stdc++.h>
using namespace std;

int n;
string input;
stack<string> st;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	string bufferflush;
	getline(cin, bufferflush);
	while (n--) {
		getline(cin, input);
		for (auto c : input) {
			string s = string(1, c);
			if (!st.empty() && st.top() == "(" && s == ")") {
				st.pop();
				continue;
			}
			st.push(s);
		}
		if(st.empty()) {
			cout << "YES" << "\n";
		}
		else {
			cout << "NO" << "\n";
		}
		st = stack<string>();
	}
}