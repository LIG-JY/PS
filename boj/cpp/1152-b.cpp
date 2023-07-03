#include <bits/stdc++.h>
using namespace std;

string s;
int res = 1;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    getline(cin, s); // cin X
    if (!s.size()) {
        cout << 0 << "\n";
        exit(0);
    }
    if (s.size() == 1 && isspace(s[0])) {
        cout << 0 << "\n";
        exit(0);
    }
    for (int i = 1; i < (int)(s.size() - 1); i++) {
        if (isspace(s[i])) {
            res++;
        }
    }
    cout << res << "\n";
    return 0;
}