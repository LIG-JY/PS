#include <bits/stdc++.h>
using namespace std;

int n,m;
string c, c_type;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> m;
        map<string,int> d;
        for (int i = 0; i < m; i++) {
            cin >> c >> c_type;
            d[c_type]++;
        }
        int res = 1;
        for (auto e : d) {
            res *= (e.second + 1);
        }
        cout << res - 1 << "\n";
    }
    return 0;
}