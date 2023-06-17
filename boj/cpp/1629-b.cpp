#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll a, b, c;
ll cal_recursive(ll a, ll b) {
    if (b == 1) {
        return a % c;
    }
    if (b & 1) {
        return (cal_recursive(a, 1) * cal_recursive(a, b-1)) % c;
    }
    else {
        return (cal_recursive(a, b/2) * cal_recursive(a, b/2)) % c;
    }
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