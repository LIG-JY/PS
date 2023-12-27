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
        int mid = (lb + ub) / 2;
        for (int i = lb; i <= mid; i++)
        {
            // 중점은 swap하지 않는다.
            if (i == lb + ub - i)
            {
                break;
            }
            // swap
            swap(cards[i], cards[lb + ub - i]);
        }
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