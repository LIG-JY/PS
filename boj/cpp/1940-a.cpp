#include<bits/stdc++.h>
using namespace std;

int n,m,e,res;
vector<int> materials;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n >> m;
    for (int i = 0 ; i < n ; i++) {
        cin >> e;
        materials.push_back(e);
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (materials[i] + materials[j] == m) {
                res++;
            }
        }
    }
    cout << res << "\n";
    return 0;
}
