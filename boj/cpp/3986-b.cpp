#include <bits/stdc++.h>
using namespace std;

int n, cnt;
string word;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> word;
        stack<char> stk;
        for (auto c : word) {
            if (stk.size() && stk.top() == c) {
                stk.pop();
            }
            else {
                stk.push(c);
            }            
        }
        if (stk.size() == 0) {
            cnt++;
        }
    }
    cout << cnt <<"\n";
}