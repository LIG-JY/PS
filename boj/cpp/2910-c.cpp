#include <bits/stdc++.h>
using namespace std;

int n,c;
int num;
map<int, int> cnt, idx;

bool cmp(const pair<int,int>& a, const pair<int,int>& b) {
    if (a.second == b.second) {
        return idx[a.first] < idx[b.first];
    } // 2순위
    return a.second > b.second; // 1순위
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> c;
    for (int i = 1; i <= n; i++) {
        cin >> num;
        cnt[num]++;
        if ((idx[num] == 0)) { // !idx.count(num) 
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