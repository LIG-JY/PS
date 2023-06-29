#include <bits/stdc++.h>
using namespace std;

int n, height, cnt, res, max_h;
int puzzle[101][101], visited[101][101];
vector<pair<int,int>> directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
queue<pair<int,int>> q;
void bfs(int limit, int x, int y) {
    visited[y][x] = 1;
    q.push({x,y});
    while (!q.empty()) {
        pair<int,int> current = q.front();
        q.pop();
        for (int i = 0 ; i < directions.size(); i++) {
            int nx = current.first + directions[i].first;
            int ny = current.second + directions[i].second;
            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            if (puzzle[ny][nx] < limit) {
                continue;
            }; // 1 ~ max_v check
            visited[ny][nx] = 1;
            q.push({nx,ny});
        }
    }
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    for (int y = 1; y <= n; y++) {
        for (int x = 1; x <= n; x++) {
            cin >> height;
            puzzle[y][x] = height;
            if (height > max_h) {
                max_h = height;
            }
        }
    }
    for (int i = 1; i <= max_h; i++) {
        memset(visited, 0, sizeof(visited));
        cnt = 0;
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if (puzzle[y][x] >= i && !visited[y][x]) {
                    bfs(i, x, y);
                    cnt++;
                }
            }
        }
        if (cnt > res) {
            res = cnt;
        }
    }
    cout << res << "\n";
}