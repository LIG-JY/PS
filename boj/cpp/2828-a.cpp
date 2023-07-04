#include <bits/stdc++.h>
using namespace std;

int n,m,k;
int idx;
int res;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m >> k;
    pair<int, int> currentLocation = {1, m}; // left most, right most
    for (int i = 0; i < k; i++) {
        cin >> idx;
        int distance = 0;
        if (idx < currentLocation.first) {
            distance = currentLocation.first - idx;
            currentLocation.first -= distance;
            currentLocation.second -= distance;
        } // left
        else if (idx > currentLocation.second) {
            distance = idx - currentLocation.second;
            currentLocation.first += distance;
            currentLocation.second += distance;
        } // right
        res += distance; // common logic
    }
    cout << res << "\n";
}