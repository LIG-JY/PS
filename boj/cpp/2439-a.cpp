#include <bits/stdc++.h>
using namespace std;

int n;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 1; i <= n; i++) {
        string s1 = string(n - i, ' ');
        string s2 = string(i, '*');
        cout << s1 + s2 << "\n";
    }
    return 0;
}