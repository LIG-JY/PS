#include<bits/stdc++.h>
using namespace std;

int cnt, N, M, materials[15001];
vector<int> ret;
void comb(int m[], int depth) {
    if (ret.size() == 2) {
        if (ret[0] + ret[1] == M) {
            cnt++;
        }
        return;
    }
    for (int i = depth + 1; i < N; i++) {
        ret.push_back(m[i]);
        comb(m, i);
        ret.pop_back();
    }
    return;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> materials[i];
    }
    if (M > 200000) {
        cout << 0 << "\n"; // time out 방지, 입력 다 끝나고 해야함
        exit(0);
    }
    comb(materials, -1);
    cout << cnt << "\n";
    return 0;
}
