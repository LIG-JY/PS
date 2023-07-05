#include <bits/stdc++.h>
using namespace std;

int a, b;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> a >> b;
    if (a > b) {
        cout << ">" << "\n";
    }
    else if (a < b) {
        cout << "<" << "\n";
    }
    else {
        cout << "==" << "\n";
    }
    return 0;
}