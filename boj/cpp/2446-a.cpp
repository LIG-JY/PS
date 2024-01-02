#include <bits/stdc++.h>
using namespace std;

int n;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    // 상단 역삼각형 별 출력
    for (int i = 1; i <= n - 1; i++)
    {
        for (int space = 1; space <= i - 1; space++)
        {
            cout << " ";
        }
        for (int star = 1; star <= 2 * (n - i) + 1; star++)
        {
            cout << "*";
        }
        cout << "\n";
    }
    // 중간 별 출력
    for (int space = 1; space <= n - 1; space++)
    {
        cout << " ";
    }
    cout << "*\n";
    // 하단 삼각형 별 출력
    for (int i = 1; i <= n - 1; i++)
    {
        for (int space = 1; space <= n - 1 - i; space++)
        {
            cout << " ";
        }
        for (int star = 1; star <= 2 * i + 1; star++)
        {
            cout << "*";
        }
        cout << "\n";
    }

    return 0;
}
