#include <bits/stdc++.h>
using namespace std;

string s;
int res = 0;
bool flag = true;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    getline(cin, s); // cin X
    for (char c : s) {
        if (flag && !isspace(c)) {
            res++;
            flag = false;
        }
        if (isspace(c)) {
            flag = true;
        }
    }
    cout << res << "\n";
}