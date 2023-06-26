#include <bits/stdc++.h>
using namespace std;

int t,m,n,k,x,y;
vector<pair<int,int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

void dfs(int x, int y, vector<vector<int>> &puzzle, vector<vector<int>> &visited) {
    visited[y][x] = 1;
    for (auto d : directions) {
        int nx = x + d.first;
        int ny = y + d.second;

        if (nx < 0 || ny < 0 || nx >= puzzle[0].size() || ny >= puzzle.size() || puzzle[ny][nx] == 0) {
            continue;
        }
        if (visited[ny][nx]) {
            continue;
        }
        dfs(nx, ny, puzzle, visited);
    }
    return;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> t;
    for (int i = 0; i < t; i++) {
        int cnt = 0;
        cin >> m >> n >> k; 
        vector<vector<int>> puzzle(n, vector<int>(m, 0));
        vector<vector<int>> visited(n, vector<int>(m, 0));
        for (int i = 0; i < k; i++) {
            cin >> x >> y;
            puzzle[y][x] = 1;
        } // make puzzle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (puzzle[i][j] == 1 && !visited[i][j]) {
                    dfs(j,i,puzzle,visited);
                    cnt++;
                }
            } 
        }
        cout << cnt << "\n";        
    }
}