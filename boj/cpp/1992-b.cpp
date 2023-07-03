#include <bits/stdc++.h>
using namespace std;

int n;
vector<string> puzzle;

string divide(int maxSize, pair<int, int> sp) {
    if (!maxSize) {
        return "";
    }
    bool isDivide = false;
    int x = sp.first;
    int y = sp.second;
    char e = puzzle[y][x];
    for (int i = y; i < y + maxSize; i++) {
        for (int j = x; j < x + maxSize; j++) {
            if (puzzle[i][j] != e) {
                isDivide = true;
                break;
            } 
        }
    }
    if (isDivide) {
        string res = "";
        vector<pair<int, int>> nextPoints = {
            {x, y},
            {x + maxSize / 2, y},
            {x, y + maxSize / 2},
            {x + maxSize / 2, y + maxSize / 2}
        };
        res += "(";        
        for (int i = 0; i < 4; i++) {
            res += divide(maxSize / 2 ,nextPoints[i]);
        }
        res += ")";
        return res;
    }
    return string(1, e);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    string bufferflush;
    getline(cin, bufferflush);
    for (int i = 0; i < n; i++) {
        string inputLine;
        getline(cin, inputLine);
        puzzle.push_back(inputLine);
    }
    cout << divide(n, {0,0}) << "\n";
    return 0;
}
