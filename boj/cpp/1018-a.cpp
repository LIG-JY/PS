#include <bits/stdc++.h>
using namespace std;

const int SIZE = 8;
int n, m;
vector<int> result_list;

int get_result(int y, int x, const vector<vector<char>> &board)
{
    int res = 0;
    vector<int> res_list;

    for (int i = 0; i < SIZE; i++)
    {
        for (int j = 0; j < SIZE; j++)
        {
            if ((i + j) % 2 == 0)
            {
                if (board[i + y][j + x] == 'W')
                {
                    res++;
                }
            }
            else
            {
                if (board[i + y][j + x] == 'B')
                {
                    res++;
                }
            }
        }
    }
    res_list.push_back(res);

    // double check
    res = 0;
    for (int i = 0; i < SIZE; i++)
    {
        for (int j = 0; j < SIZE; j++)
        {
            if ((i + j) % 2 == 0)
            {
                if (board[i + y][j + x] == 'B')
                {
                    res++;
                }
            }
            else
            {
                if (board[i + y][j + x] == 'W')
                {
                    res++;
                }
            }
        }
    }
    res_list.push_back(res);
    return *min_element(res_list.begin(), res_list.end());
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;
    vector<vector<char>> board(n, vector<char>(m, 0));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> board[i][j];
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (i + 8 > n)
            {
                continue;
            }
            if (j + 8 > m)
            {
                continue;
            }
            result_list.push_back(get_result(i, j, board));
        }
    }
    cout << *min_element(result_list.begin(), result_list.end());
}