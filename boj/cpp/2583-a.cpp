#include <bits/stdc++.h>
using namespace std;

int m, n, k, cnt;
int under_x, under_y, upper_x, upper_y;
int puzzle[101][101], visited[101][101], areas[10000];
string s;
vector<pair<int,int>> directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

void dfs(int x, int y, int index) {
    visited[y][x] = 1;
    areas[index]++;
    for (int i = 0; i < 4; i++) {
        int nx = x + directions[i].first;
        int ny = y + directions[i].second;
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
            continue;
        }
        if (visited[ny][nx]) {
            continue;
        }
        if (!puzzle[ny][nx]) {
            continue;
        }
        dfs(nx,ny,index);
    }
    return;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    fill(&puzzle[0][0], &puzzle[0][0] + 101 * 101, 1);
    cin >> m >> n >> k;
    // make map
    for (int i = 0; i < k; i++) {
        cin >> under_x >> under_y >> upper_x >> upper_y;
        upper_y = m - upper_y;
        under_y = m - under_y; // symmetric trans
        for (int y = upper_y; y < under_y; y++) {
            for (int x = under_x; x < upper_x; x++) {
                puzzle[y][x] = 0;
            }
        }
    }

    for (int y = 0; y < m; y++) {
        for (int x = 0; x < n; x++) {
            if (puzzle[y][x] && !visited[y][x]) {
                dfs(x,y,cnt);
                cnt++;
            }
        }
    } // cnt, area;

    vector<int> res;
    for (int i = 0 ; i < cnt; i++) {
        res.push_back(areas[i]);
    }
    sort(res.begin(), res.end());
    // sort
    
    cout << cnt << "\n";
    for (int i = 0 ; i < cnt; i++) {
        cout << res[i];
        if (i < cnt - 1) {
            cout << " ";
        }
    }
    cout << "\n";
}