#include <bits/stdc++.h>
using namespace std;

string input;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (1) {
		getline(cin, input);
		if (input == ".") {
			break;
		}
		stack<char> st;
		bool isBalance = true;
		for (char c : input) {
			if (c == ')') {
				if(st.empty() || st.top() == '[') {
					isBalance = false;
					break;
				}
				else {
					st.pop();
				}
			}
			if (c == ']') {
				if(st.empty() || st.top() == '(') {
					isBalance = false;
					break;
				}
				else {
					st.pop();
				}
			}
			if (c == '(' || c == '[') {
				st.push(c);
			}
		}
		if (isBalance && st.empty()) {
			cout << "yes" << "\n";
		}
		else {
			cout << "no" << "\n";
		}
	}
	return 0;
}