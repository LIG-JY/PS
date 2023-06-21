#include<bits/stdc++.h>
using namespace std;

bool num[10001];
int run, res;
void d(int n) {
    if (n > 10000 || n <= 0) {
        return;
    }
    run = n;
    res = n;
    while (run) {
        res += (run % 10);
        run /= 10;
    }
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