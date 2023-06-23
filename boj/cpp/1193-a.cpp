#include <bits/stdc++.h>
using namespace std;

long long n, input, x, y;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> input;
    n = 1;
    while (input > (n * (n + 1)) / 2) {
        n++;
    }
    input = (n * (n + 1)) / 2 - input;
    if (n & 1) {
        x = 1;
        y = n;
        while (input--) {
            x++;
            y--;
        }
    }
    else {
        x = n;
        y = 1;
        while (input--) {
            x--;
            y++;
        }
    }
    cout << x << "/" << y <<"\n";
}