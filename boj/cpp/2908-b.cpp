#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string n, m;
	cin >> n >> m;

	string reversedN = n;
	string reversedM = m;

	reverse(reversedN.begin(), reversedN.end());
	reverse(reversedM.begin(), reversedM.end());

	if (reversedN >= reversedM)
	{
		cout << reversedN << "\n";
	}
	else
	{
		cout << reversedM << "\n";
	}

	return 0;
}
