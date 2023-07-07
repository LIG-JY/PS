#include <bits/stdc++.h>
using namespace std;

long long n, num, cnt1, cnt2;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    while (n--) {
        cin >> num;
        cnt1 = cnt2 = 0;
        for (int i = 2; i <= num; i *= 2) {
            cnt1 += num / i;            
        }
        for (int i = 5; i <= num; i *= 5) {
            cnt2 += num / i;
        }
        cout << min(cnt1 , cnt2) << "\n";
    }
}