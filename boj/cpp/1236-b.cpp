#include <iostream>
using namespace std;

char input;
int n, m, empty_row, empty_col;
int castle[50][50];

bool row_check(int row);
bool col_check(int col);

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
		if (!row_check(i))
		{
			empty_row++;
		}
	}

	for (int i = 0; i < m; i++)
	{
		if (!col_check(i))
		{
			empty_col++;
		}
	}

	cout << (empty_col > empty_row ? empty_col : empty_row);

	// for (int i = 0; i < n; i++)
	// {
	// 	for (int j = 0; j < m; j++)
	// 	{
	// 		cout << castle[i][j];
	// 	}
	// 	cout << "\n";
	// }

	return 0;
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
