#include <bits/stdc++.h>
using namespace std;

struct Node{
    int row;
    int col;
    int depth;
};
const int _MAX = 104;
int n,m,puzzle[_MAX][_MAX],res;
bool visited[_MAX][_MAX];
int main() {
    ios_base::sync_with_stdio(false);
    cout.tie(NULL); 
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &puzzle[i][j]);
        }
    }

    int dr[] = {-1, 1, 0, 0};
    int dc[] = {0, 0, -1, 1}; // 배열의 크기는 초기값의 개수로 자동 결정된다.

    queue<Node> q;
    q.push({0,0,0});
    while (!q.empty()) {
        Node current = q.front();
        q.pop();
        
        int row = current.row;
        int col = current.col;
        int depth = current.depth;

        if (row == m - 1 && col == n - 1) {
            res = depth;
            break;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }
            if (puzzle[nc][nr] == 0) {
                continue;
            }
            if (visited[nc][nr]) {
                continue;
            }
            q.push({nr, nc, depth + 1});
            visited[nc][nr] = true;
        }
    }
    cout << res + 1 << "\n";
    return 0;
}