#include <bits/stdc++.h>
using namespace std;

int n,c;
int num;
map<int, int> cnt;
map<int, int> idx;

bool cmp(const pair<int,int>& a, const pair<int,int>& b) {
    if (a.second == b.second) {
        return idx[a.first] < idx[b.first];
    }
    return a.second > b.second;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> c;
    for (int i = 1; i <= n; i++) {
        cin >> num;
        cnt[num]++;
        if (!idx.count(num)) {
            idx[num] = i;
        }
    }
    vector<pair<int,int>> temp;
    for (auto entry : cnt) {
        temp.push_back(entry);
    }
    sort(temp.begin(), temp.end(), cmp);
    for (auto e : temp) {
        for (int i = 0; i < e.second; i++) {
            cout << e.first << " ";
        }
    }
    return 0;
}