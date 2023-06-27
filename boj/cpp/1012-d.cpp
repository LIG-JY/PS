#include <bits/stdc++.h>
using namespace std;

vector<pair<int,int>> directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
int t, m, n, k, x, y, cnt;
int puzzle[51][51], visited[51][51];
queue<pair<int, int>> q;

void bfs(int x, int y) {
    visited[y][x] = 1;
    q.push({x, y});
    while (!q.empty()) {
        pair<int,int> current = q.front();
        q.pop();
        for (int i = 0 ; i < 4; i++) {
            int nx = current.first + directions[i].first;
            int ny = current.second + directions[i].second;
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            if (!puzzle[ny][nx]) {
                continue;
            }
            visited[ny][nx] = 1;
            q.push({nx,ny});
        }
    }
    return;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> t;
    for (int i = 0; i < t; i++) {
        // make map
        cin >> m >> n >> k;
        fill(&puzzle[0][0], &puzzle[0][0] + 51 * 51, 0);
        fill(&visited[0][0], &visited[0][0] + 51 * 51, 0); // initialize

        for (int i = 0; i < k; i++) {
            cin >> x >> y;
            puzzle[y][x] = 1; // push_earthworm
        }

        // search
        cnt = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (!visited[y][x] && puzzle[y][x]) {
                    bfs(x,y);
                    cnt++;
                }
            }
        }
        cout << cnt << "\n";
    }
}