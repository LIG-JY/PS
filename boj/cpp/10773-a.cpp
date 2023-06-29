#include <bits/stdc++.h>
using namespace std;

int k, idx, money, res;
int st[100001];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> k;
    for (int i = 0; i < k; i++) {
        cin >> money;
        if (!money) {
            idx--;
            st[idx] = 0;
            continue;
        }
        st[idx] = money;
        idx++;
    }
    for (int i = 0; i <= idx; i++) {
        res += st[i];
    }
    cout << res << "\n";
}
