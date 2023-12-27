#include <bits/stdc++.h>
using namespace std;

int lb, ub; // lower bound, upper bound
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    vector<int> cards(21);
    for (int i = 1; i <= 20; i++)
    {
        cards[i] = i;
    }

    for (int loop = 0; loop < 10; loop++)
    {
        cin >> lb >> ub;
        // STL의 reverse 함수를 이용하여 벡터의 일부를 뒤집는다.
        reverse(cards.begin() + lb, cards.begin() + ub + 1);
    }

    // 출력
    for (int i = 1; i <= 20; i++)
    {
        cout << cards[i];
        if (i != 20)
        {
            cout << " ";
        }
    }
    return 0;
}