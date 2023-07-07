#include <bits/stdc++.h>
using namespace std;

string s,p;
int t,r;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    while (t--) {
        p = "";
        cin >> r >> s;
        for(char c : s) {
            p += string(r,c);
        }
        cout << p << "\n";
    }
}