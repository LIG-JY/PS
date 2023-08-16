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
    int res = 1;
    while (num > 0) {
        res *= num;
        num--;
    }
    return res;
}