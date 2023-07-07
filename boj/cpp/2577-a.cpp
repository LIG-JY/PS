#include <bits/stdc++.h>
using namespace std;

int a,b,c,n;
int cnt[10];
string s;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> a >> b >> c;
    n = a * b * c;
    s = to_string(n);
    for (char c : s) {
        cnt[c - '0']++;
    }
    for (int e : cnt) {
        cout << e << "\n";
    }
    return 0;
}