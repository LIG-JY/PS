#include <bits/stdc++.h>
using namespace std;

string res = "EABCD";
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int i = 0; i < 3; i++)
    {
        int zero_cnt = 0;
        for (int j = 0; j < 4; j++)
        {
            // 윷
            int yut;
            cin >> yut;
            if (yut == 0)
            {
                zero_cnt++;
            }
        }
        cout << res[zero_cnt] << '\n';
    }
    return 0;
}