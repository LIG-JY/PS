#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<char> prime_list;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;

    // 체 채우기
    for (int i = 0; i <= m; i++)
    {
        prime_list.push_back(1);
    }

    // 1 제외
    prime_list[1] = 0;

    // 2 부터 m까지 소수 찾기
    for (int i = 2; i * i <= m; i++)
    {
        // 해당 숫자가 소수면 이 숫자의 배수는 모두 소수가 아님
        // 2 -> 4, 6, 8 등 모두 소수가 아니다.
        if (prime_list[i])
        {
            for (int j = i * i; j <= m; j += i)
            {
                prime_list[j] = 0;
            }
        }
    }

    // 출력
    for (int i = n; i <= m; i++)
    {
        if (prime_list[i])
        {
            cout << i << "\n";
        }
    }
    return 0;
}