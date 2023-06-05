#include<bits/stdc++.h>
using namespace std;
int arr[9];
int sum;
int res[7];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	for (int i=0; i < 9; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + 9);
	do {
		sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += arr[i];
		}
		if (sum == 100) {
			for (int i = 0; i < 7; i++) {
				res[i] = arr[i];
			}
			sort(res, res+7);
			break;
		}
	} while (next_permutation(arr, arr+9));
	for (int i = 0; i < 7; i++) {
		cout << res[i] << '\n';
	}
    return 0;
}