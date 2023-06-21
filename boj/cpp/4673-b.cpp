#include<bits/stdc++.h>
using namespace std;

bool num[10001];
int res;

int sumOfDigits(int num) {
    int res = num;
    while (num) {
        res += (num % 10);
        num /= 10;
    }
    return res;
}

void d(int n) {
    if (n > 10000 || n <= 0) {
        return;
    }
    res = sumOfDigits(n);
    if (res < 10000 && !num[res]) {
        num[res] = true;
    }
    d(res);
}

int main() {
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    for (int i = 1; i < 10000; i++) {
        d(i);
    }
    for (int i = 1; i < 10000; i++) {
        if (!num[i]) {
            cout << i << "\n";
        }
    }
}