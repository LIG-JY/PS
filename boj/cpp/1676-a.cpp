#include <bits/stdc++.h>
using namespace std;

int n;

// get count of prime factor
int get_cnt_of_pf(int n, const int prime_factor)
{
    int cnt = 0;
    // calculate cnt of prime factor
    while (n % prime_factor == 0)
    {
        cnt++;
        n /= prime_factor;
    }
    return cnt;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    int cnt_of_two = 0;
    int cnt_of_five = 0;

    for (int i = 1; i <= n; i++)
    {
        cnt_of_five += get_cnt_of_pf(i, 5);
        cnt_of_two += get_cnt_of_pf(i, 2);
    }

    int cnt_of_trailing_zero = min(cnt_of_five, cnt_of_two);
    cout << cnt_of_trailing_zero;
}