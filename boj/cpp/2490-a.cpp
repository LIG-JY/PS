#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int i = 0; i < 3; i++)
    {
        // 0 과 1의 개수를 세는 배열
        int arr[2] = {0, 0};
        for (int j = 0; j < 4; j++)
        {
            int a;
            cin >> a;
            arr[a]++;
        }
        // 도
        if (arr[0] == 1)
        {
            cout << "A"
                 << "\n";
        }
        // 개
        else if (arr[0] == 2)
        {
            cout << "B"
                 << "\n";
        }
        // 걸
        else if (arr[0] == 3)
        {
            cout << "C"
                 << "\n";
        }
        // 윷
        else if (arr[0] == 4)
        {
            cout << "D"
                 << "\n";
        }
        // 모
        else
        {
            cout << "E"
                 << "\n";
        }
    }
    return 0;
}