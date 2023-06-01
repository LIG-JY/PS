#include<bits/stdc++.h>
using namespace std;

string S;
map<char, int> mp;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	getline(cin, S);
	for (char c = 'a'; c <= 'z'; c++) {
		mp[c] = 0;
	}
	for (auto c : S) {
		mp[c]++;
 	}
	for (auto it : mp) {
		cout << it.second << " ";
	}
    return 0;
}