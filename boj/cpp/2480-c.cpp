#include <bits/stdc++.h>
using namespace std;

vector<int> dice_eyes(3);
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int i = 0; i < 3; i++)
    {
        cin >> dice_eyes[i];
    }

    sort(dice_eyes.begin(), dice_eyes.end());
    // 같은 눈 3개
    if (dice_eyes[0] == dice_eyes[2])
    {
        cout << 10000 + dice_eyes[0] * 1000;
    }
    // 같은 눈 2개
    else if (dice_eyes[0] == dice_eyes[1] || dice_eyes[1] == dice_eyes[2])
    {
        cout << 1000 + dice_eyes[1] * 100;
    }
    // 모두 다른 눈
    else
    {
        cout << dice_eyes[2] * 100;
    }
    return 0;
}