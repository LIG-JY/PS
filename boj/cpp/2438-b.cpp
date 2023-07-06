#include <bits/stdc++.h>
using namespace std;

int n;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    string s = string(n, ' ');
    for (int i = 1; i <= n; i++) {
        string sub1 = s.substr(0, n - i);
        string sub2 = string(i, '*');
        cout << sub1 + sub2 << "\n";
    }
    return 0;
}