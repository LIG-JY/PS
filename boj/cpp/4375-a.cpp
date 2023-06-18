#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    while (scanf("%d", &n) != EOF) {
        ll num = 1;
        int cnt = 1;
        while (num % n) {
            num = ((10 * num) % n + (1 % n));
            cnt++;
        }
        cout << cnt << "\n";
    }
    return 0;
}