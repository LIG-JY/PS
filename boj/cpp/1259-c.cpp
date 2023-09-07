#include <bits/stdc++.h>
using namespace std;

bool isPalindrome(string &num);

string input;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	do
	{
		cin >> input;
		if (input != "0")
		{
			cout << (isPalindrome(input) ? "yes" : "no") << "\n";
		}
	} while (input != "0");

	return 0;
}

bool isPalindrome(string &num)
{
	int size = num.size();

	// Check if the number is a palindrome
	int i = 0, j = size - 1;
	while (i < j)
	{
		if (num[i] != num[j])
		{
			return false;
		}
		i++;
		j--;
	}
	return true;
}
