#include <iostream>
using namespace std;

bool isPalindrome(int num);

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int input;
	do
	{
		cin >> input;
		if (input)
		{
			cout << (isPalindrome(input) ? "yes" : "no") << "\n";
		}

	} while (input);

	return 0;
}

bool isPalindrome(int num)
{
	string s = to_string(num);
	int i = 0, j = s.length() - 1;
	while (i < j)
	{
		if (s[i] != s[j])
		{
			return false;
		}
		i++;
		j--;
	}
	return true;
}

