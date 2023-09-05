#include <iostream>
#include <string>

using namespace std;

int boxes[51], books_q[51], capacities[51];
int n, m, input, res;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n >> m;
	for (int i = 1; i <= n; i++)
	{
		cin >> input;
		boxes[i] = input;
	}

	for (int i = 1; i <= m; i++)
	{
		cin >> input;
		books_q[i] = input;
	}

	int book_idx = 1;
	for (int box_idx = 1; box_idx <= n && book_idx <= m; box_idx++)
	{
		while (book_idx <= m)
		{
			if (capacities[box_idx] + books_q[book_idx] <= boxes[box_idx])
			{
				capacities[box_idx] += books_q[book_idx];
				book_idx++;
			}
			else
			{
				break;
			}
		}
	}

	for (int box_idx = 1; box_idx <= n; box_idx++)
	{
		res += (boxes[box_idx] - capacities[box_idx]);
	}
	cout << res;

	return 0;
}