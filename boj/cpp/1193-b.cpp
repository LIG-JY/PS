#include <bits/stdc++.h>
using namespace std;

long long n, input, x, y;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> input;
    for (n = 1; n < input; n++) {
        input -= n; // minus 1, 2, 3 .... n
    }
    if (n & 1) {
        x = n;
        y = 1;
        while (--input) {
            x--;
            y++;
        }
    }
    else {
        x = 1;
        y = n;
        while (--input) {
            x++;
            y--;
        }
    }
    cout << x << "/" << y <<"\n";
}