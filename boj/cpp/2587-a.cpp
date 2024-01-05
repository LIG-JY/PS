#include <bits/stdc++.h>
using namespace std;

int arr[5];
int sum;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 5; i++)
    {
        cin >> arr[i];
        sum += arr[i];
    }

    sort(arr, arr + 5);

    cout << sum / 5 << "\n"
         << arr[2];

    return 0;
}
