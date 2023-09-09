#include <iostream>
using namespace std;

string input;
char vowel[10] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	while (true)
	{
		getline(cin, input);
		if (input == "#")
		{
			break;
		}
		int res = 0;
		for (char c : input)
		{
			for (char v : vowel)
			{
				if (c == v)
				{
					res++;
				}
			}
		}
		cout << res << "\n";
	}

	return 0;
}
