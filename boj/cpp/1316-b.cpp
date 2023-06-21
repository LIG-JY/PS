#include <bits/stdc++.h>
using namespace std;

int n,cnt;
string s;
constexpr int ALPABET_SIZE = 26;
bool check[ALPABET_SIZE];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    for (int i = 0; i < n; i++) {
        fill(&check[0], &check[26], false);
        cin >> s;
        char prevChar = 0;
        for (char c : s) {
            if (check[c - 'a'] && (prevChar != c)) {
                cnt++;
                break;
            }
            check[s[i]- 'a'] = true;
            prevChar = c;
        }
    }
    cout << n - cnt << "\n";
}