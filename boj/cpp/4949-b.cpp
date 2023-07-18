#include <bits/stdc++.h>
using namespace std;

string input;
stack<char> st;
void go(char c) {
	if (st.empty()) {
		st.push(c);
		return;
	}
	if ((c == ')' && st.top() == '(') || (c == ']' && st.top() == '[')) {
		st.pop();
		return;
	}
	st.push(c);
	return;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (1) {
		getline(cin, input);
		if (input == ".") {
			break;
		}
		input.erase(input.size() - 1);
		for (char c : input) {
			if (c == '(' || c == ')' || c == '[' || c == ']') {
				go(c);
			} 
		}
		if (st.empty()) {
			cout << "yes" << "\n";
		}
		else {
			cout << "no" << "\n";
		}
		st = stack<char>(); // stack initialize
	}
	return 0;
}