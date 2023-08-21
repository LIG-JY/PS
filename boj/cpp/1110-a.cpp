#include <iostream>
using namespace std;

int getNextNumber(int n)
{
	int tens, units;
	if (n < 10)
	{
		tens = 0;
		units = n;
	}
	else
	{
		tens = n / 10;
		units = n % 10;
	}
	return (units * 10) + (tens + units) % 10;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int inputNum, tempNum, cycleLength = 0;

	cin >> inputNum;
	tempNum = inputNum;

	do
	{
		tempNum = getNextNumber(tempNum);
		cycleLength++;
	} while (inputNum != tempNum);

	cout << cycleLength;

	return 0;
}
