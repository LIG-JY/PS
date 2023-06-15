#include<bits/stdc++.h>
using namespace std;

string org, res;
int cnt[200], odd_cnt;
char mid;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    getline(cin, org);
    for (auto it : org) {
        cnt[(int)it]++;
    }
    for (int i = 'Z'; i >= 'A'; i--) {
        if (cnt[i] & 1) {
            odd_cnt++;
            mid = (char)i;
            cnt[i]--;
        }
        if (odd_cnt > 1) {
            cout << "I'm Sorry Hansoo" << "\n";
            exit(0);
        }
        for (int j = 0; j < cnt[i] / 2; j++) {
            res += (char)i;
            res = (char)i + res;
        }
    }
    if (odd_cnt == 1) {
        res.insert(res.begin() + res.size()/2, mid);
    }
    cout << res << "\n";
    return 0;
}
