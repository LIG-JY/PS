#include <bits/stdc++.h>
using namespace std;

int k, money, res;
stack<int> st;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> k;
    for (int i = 0; i < k; i++) {
        cin >> money;
        if (!money) {
            st.pop();
            continue;
        }
        st.push(money);
    }
    while(!st.empty()) {
        int m = st.top();
        res += m;
        st.pop();
    }
    cout << res << "\n";
}
