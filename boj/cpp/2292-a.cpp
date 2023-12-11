#include <bits/stdc++.h>
using namespace std;

int n;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    if (n == 1)
    {
        cout << 1;
        return 0;
    }

    // 6 * answer로 layer의 크기 결정
    int last_bound = 1;
    int answer = 1;
    bool out_bound = true;
    while (out_bound)
    {
        if (n > last_bound && n <= last_bound + 6 * answer)
        {
            out_bound = false;
        }
        last_bound += 6 * answer;
        answer++;
    }
    cout << answer;
    return 0;
}