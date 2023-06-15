#include <bits/stdc++.h>
using namespace std;

map<char, int> t;
string org, res, rev;
char odd_char;
int odd;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    getline(cin, org);
    for (auto it : org) {
        t[it]++;
    }
    for (auto e : t) {
        if (e.second % 2 == 1) {
            odd++;
            odd_char = e.first;
        }
    }
    if (odd > 1) {
        cout << "I'm Sorry Hansoo" << "\n";
    }
    else if (odd == 1) {
        t[odd_char]--;
        for (auto e : t) {
            for (int i = 0; i < e.second / 2; i++) {
                res += e.first;
            }
        }
        rev = res;
        reverse(rev.begin(), rev.end());
        res += odd_char;
        res += rev;
        cout << res << "\n";
    }
    else {
       for (auto e : t) {
            for (int i = 0; i < e.second / 2; i++) {
                res += e.first;
            }
        } 
        rev = res;
        reverse(rev.begin(), rev.end());
        res += rev;
        cout << res << "\n";
    }
    return 0;
}