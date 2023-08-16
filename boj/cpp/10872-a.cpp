#include <bits/stdc++.h>

using namespace std;

void go(int &);

int n;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    if (n == 0) {
        cout << 1;
    }
    else {
        go(n);
        cout << n;
    }
}

void go(int &num) {
    for (int i = num - 1; i > 0; i--) {
        num *= i;
    }
}