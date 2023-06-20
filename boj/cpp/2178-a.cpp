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
        cout << row << " " << col << " " << depth << "\n";

        if (row < 0 || col < 0 || row >= m || col >= n || puzzle[col][row] == 0) {
            continue;
        }

        if (visited[col][row]) {
            continue;
        }

        visited[col][row] = true;

        if (row == m - 1 && col == n - 1) {
            res = depth;
            break;
        }

        for (int i = 0; i < 4; i++) {
            q.push({row + dr[i], col + dc[i], depth + 1});
        }
    }
    cout << res + 1 << "\n";
    return 0;
}