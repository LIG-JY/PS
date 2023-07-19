#include <bits/stdc++.h>
using namespace std;

int alphabet[26];
string input;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	memset(alphabet, -1, sizeof(alphabet));

	cin >> input;
	for (int i = 0; i < input.size(); i++) {
		if (alphabet[input[i] - 'a'] == -1) {
			alphabet[input[i] - 'a'] = i;
		}
	}
	for (int num : alphabet) {
		cout << num << " ";
	}
	return 0;
}