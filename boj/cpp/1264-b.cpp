#include <iostream>
#include <set>

using namespace std;

const set<char> vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

int countVowels(const string &input)
{
	int res = 0;
	for (auto c : input)
	{
		if (vowels.find(c) != vowels.end()) // set.find return iterator(RBT : O(logn))
		{
			res++;
		}
	}
	return res;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string input;
	while (true)
	{
		getline(cin, input);
		if (input == "#")
		{
			break;
		}
		cout << countVowels(input) << "\n";
	}

	return 0;
}
