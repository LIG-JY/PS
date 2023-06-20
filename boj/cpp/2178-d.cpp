#include <bits/stdc++.h>
using namespace std;

const int _MAX = 104;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1}; // 배열의 크기는 초기값의 개수로 자동 결정된다.
int n,m,puzzle[_MAX][_MAX],x,y,res,visited[_MAX][_MAX];
int main() {
    ios_base::sync_with_stdio(false);
    cout.tie(NULL); 
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &puzzle[i][j]);
        }
    }

    queue<pair<int,int>> q;
    q.push({0,0});
    visited[0][0] = 1;
    while (!q.empty()) {
        tie(x, y) = q.front(); // current coordinate
        q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i]; 
            if (nx >= 0 && nx < m 
            && ny >= 0 && ny < n
            && puzzle[ny][nx] == 1
            && !visited[ny][nx]) {
                q.push({nx, ny});
                visited[ny][nx] = visited[y][x] + 1;
            }
        }
    }
    cout << visited[n-1][m-1] << "\n";
    return 0;
}