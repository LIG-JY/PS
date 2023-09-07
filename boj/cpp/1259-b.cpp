#include <iostream>
using namespace std;

int arr[5], input, num;
void go(int *arr, int size);
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	do
	{
		cin >> input;
		num = input;
		int size = 0;
		for (int i = 0; i < 5 && num > 0; i++)
		{
			arr[i] = (num % 10);
			num /= 10;
			size++;
		}
		if (size)
		{
			go(arr, size);
		}

	} while (input);

	return 0;
}

void go(int *arr, int size)
{
	int i = 0;
	int j = size - 1;
	while (i < j)
	{
		if (arr[i] != arr[j])
		{
			cout << "no"
				 << "\n";
			return;
		}
		i++;
		j--;
	}
	cout << "yes"
		 << "\n";
	return;
}