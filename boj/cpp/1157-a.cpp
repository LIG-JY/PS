#include <bits/stdc++.h>
using namespace std;

map<char, int> cnt;
string s;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    getline(cin, s);
    for (char c : s) {
        if (c >= 'a' && c <= 'z') {
            cnt[c - ('a' - 'A')]++;
            continue;
        }
        cnt[c]++;
    }
    int max = 0;
    string res = "";
    bool dup = false;
    for (auto entry : cnt) {
        if (entry.second > max) {
            max = entry.second;
            res = string(1, entry.first);
            dup = false;
            continue;
        }
        if (entry.second == max) {
            dup = true;
            continue;
        }
    }
    if (dup) {
        cout << "?" << "\n";
        exit(0);
    }
    cout << res << "\n";
    return 0;
}