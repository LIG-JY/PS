#include<bits/stdc++.h>
using namespace std;

int k = 7, n = 9;
int a[9];
vector<int> basket;
void output(vector<int> b) {
	for (int i : b) {
		cout << i << '\n';
	}
}

void combi(int start, vector<int> b) {
	if (b.size() == k) {
		if (accumulate(b.begin(), b.end(), 0) == 100) {
			output(b);
			exit(0);
		}
		return;
	}
	for (int i = start + 1; i < n; i++){
		b.push_back(a[i]);
		combi(i, b);
		b.pop_back();
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
	for (int i  = 0; i < n; i++) {
		cin >> a[i];
	}
	sort(a, a + 9);
	combi(-1 , basket);
    return 0;
}