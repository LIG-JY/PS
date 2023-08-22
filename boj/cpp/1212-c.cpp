#include <iostream>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string input;
	cin >> input;

	string binaryTable[8] = {"000", "001", "010", "011", "100", "101", "110", "111"};
	string binaryTable2[8] = {"0", "1", "10", "11", "100", "101", "110", "111"};

	for (int i = 0; i < input.size(); i++)
	{
		int index = input[i] - '0';

		if (index > 7)
		{
			return 0; // invalid input
		}

		string binarySegment = binaryTable[index];
		if (i == 0)
		{
			binarySegment = binaryTable2[index];
		}
		cout << binarySegment;
	}

	// 16ms
	return 0;
}
