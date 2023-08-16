#include <bits/stdc++.h>

using namespace std;

int go(int num);

int n;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    cout << go(n);
}

int go(int num) {
    if (num == 0) {
        return 1;
    }
    return num * go(num - 1);
}