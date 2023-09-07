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
	string origin = num;
	reverse(num.begin(), num.end());
	return origin == num;
}
