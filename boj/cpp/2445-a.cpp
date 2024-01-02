#include <bits/stdc++.h>
using namespace std;

int n;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    // 상단 공백으로 역삼각형 출력
    for (int i = 1; i <= n - 1; i++)
    {
        // 별 출력
        for (int star = 1; star <= i; star++)
        {
            cout << "*";
        }
        // 중간 공백 출력
        for (int space = 1; space <= 2 * n - 2 * i; space++)
        {
            cout << " ";
        }
        // 대칭으로 별 출력
        for (int star = 1; star <= i; star++)
        {
            cout << "*";
        }
        cout << "\n";
    }
    // 중단 별 라인 출력
    for (int i = 1; i <= 2 * n; i++)
    {
        cout << "*";
    }
    cout << "\n";
    // 하단 공백 삼각형 출력
    for (int i = 1; i <= n - 1; i++)
    {
        // 별 출력
        for (int star = n - i; star >= 1; star--)
        {
            cout << "*";
        }
        // 중간 공백 출력
        for (int space = 2 * i; space >= 1; space--)
        {
            cout << " ";
        }
        // 별 출력
        for (int star = n - i; star >= 1; star--)
        {
            cout << "*";
        }
        cout << "\n";
    }

    return 0;
}
