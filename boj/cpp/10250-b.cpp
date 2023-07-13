#include <bits/stdc++.h>
using namespace std;

int t,h,w,n;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		cin >> h >> w >> n;
		string x = to_string(n % h ? n / h + 1 : n / h); 
		string y = to_string((n - 1) % h + 1); // n % h ? n % h : h
		cout << y + ("0" + x).substr(x.size() - 1) << "\n";
	}
}