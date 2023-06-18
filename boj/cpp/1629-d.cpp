#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll a, b, c;
ll cal_loop(ll a, ll b) {
    ll res = 1;
    while (b) {
        if (b & 1) {
            res = (res * a) % c;
        }
        a = (a * a) % c;
        b >>= 1;
    }
    return res;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> a >> b >> c;
    if (a % c == 0) {
        cout << 0 << "\n";
        exit(0);
    }
    cout << cal_loop(a, b) << "\n";
    return 0;
}