#include <bits/stdc++.h>
using namespace std;

int n,cnt;
string s;
bool check[26];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    for (int i = 0; i < n; i++) {
        fill(&check[0], &check[26], false);
        cin >> s;
        for (int i = 0; i < s.size(); i++) {
            if (check[s[i] - 'a'] && (s[i-1] != s[i])) {
                cnt++;
                break;
            }
            check[s[i]- 'a'] = true;
        }
    }
    cout << n - cnt << "\n";
}