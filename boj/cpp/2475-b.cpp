#include <bits/stdc++.h>
using namespace std;

int num,res;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i = 0; i < 5; i++) {
        cin >> num;
        res += (num * num);
    }

    cout << res % 10 << "\n";

    return 0;
}