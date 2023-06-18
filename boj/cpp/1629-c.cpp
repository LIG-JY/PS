#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll a, b, c;
ll cal_recursive(ll a, ll b) {
    ll res = 1;
    if (b & 1) {
            b -= 1;
            res *= (a % c);
        }
    while (b > 1) {
        b >>= 2;
        a = (a * a) % c;
    }
    return (res * a) % c;
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
    cout << cal_recursive(a, b) << "\n";
    return 0;
}