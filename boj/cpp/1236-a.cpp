#include <iostream>
using namespace std;

char input;
int n, m, res;
int castle[50][50];

bool row_check(int row);
bool col_check(int col);
bool cross_check(int y, int x);

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> input;
			if (input == 'X')
			{
				castle[i][j] = 1;
			}
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (castle[i][j] == 0 && !cross_check(i, j))
			{
				castle[i][j] = 1;
				res++;
			}
		}
	}

	for (int i = 0; i < n; i++)
	{
		if (!row_check(i))
		{
			res++;
			castle[i][0] = 1;
		}
	}

	for (int i = 0; i < m; i++)
	{
		if (!col_check(i))
		{
			res++;
			castle[0][i] = 1;
		}
	}
	cout << res << "\n";

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cout << castle[i][j];
		}
		cout << "\n";
	}

	return 0;
}

bool cross_check(int y, int x)
{
	return col_check(x) || row_check(y);
}

bool row_check(int row)
{
	for (int i = 0; i < m; i++)
	{
		if (castle[row][i] == 1)
		{
			return true;
		}
	}
	return false;
}

bool col_check(int col)
{
	for (int i = 0; i < n; i++)
	{
		if (castle[i][col] == 1)
		{
			return true;
		}
	}
	return false;
}

/*
....XXXX
........
XX.X.XX.
........
........
*/
