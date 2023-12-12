#include <bits/stdc++.h>
using namespace std;

// 유클리드 호제법
int euclidean_algorithm(int num1, int num2)
{
    while (num2 != 0)
    {
        num1 %= num2;
        swap(num1, num2);
    }
    return num1;
}

int a, b;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    // 두 자연수를 입력받는다.
    cin >> a >> b;

    int gcd = euclidean_algorithm(a, b);
    cout << gcd << "\n"
         << a * b / gcd;
    return 0;
}