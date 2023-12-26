#include <bits/stdc++.h>
using namespace std;

long long a, b;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> a >> b;
    // b가 a보다 크게 사전 작업
    if (a > b)
    {
        swap(a, b);
    }
    // 두 수가 같으면 함수 종료
    if (b == a)
    {
        cout << 0;
        return 0;
    }
    cout << b - a - 1 << "\n";
    for (long long i = a + 1; i < b; i++)
    {
        cout << i << " ";
    }
    return 0;
}