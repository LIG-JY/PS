#include <bits/stdc++.h>
using namespace std;

int n,m,k,l,r;
int idx;
int res;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m >> k;
    l = 1;
    r = m;
    for (int i = 0; i < k; i++) {
        cin >> idx;
        int distance = 0;
        if (idx < l) {
            distance = l - idx;
            l -= distance;
            r -= distance;
        } // left
        else if (idx > r) {
            distance = idx - r;
            l += distance;
            r += distance;
        } // right
        res += distance; // common logic
    }
    cout << res << "\n";
}