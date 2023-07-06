#include <bits/stdc++.h>
using namespace std;

int n;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 1; i <= n; i++) {
        string s = "";
        for (int j = 0; j < n - i; j++) {
            s += ' ';
        }
        for (int k = 0; k < i; k++) {
            s += '*';
        }
        cout << s << "\n";
    }
    return 0;
}