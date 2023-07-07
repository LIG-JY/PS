#include <bits/stdc++.h>
using namespace std;

int input, res, idx, arr[10];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i = 1; i <= 9; i++) {
        cin >> input;
        arr[i] = input;
    }
    for (int i = 1; i <= 9; i++) {
        if (arr[i] > res) {
            res = arr[i];
            idx = i;
        }
    }
    cout << res << "\n";
    cout << idx << "\n";
}