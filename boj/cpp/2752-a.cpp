#include <bits/stdc++.h>
using namespace std;

int a, b, c;
int d, e, f;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> a >> b >> c;

    // max
    d = min({a, b, c});
    f = max({a, b, c});
    e = a + b + c - d - f;

    cout << d << " " << e << " " << f;

    return 0;
}
