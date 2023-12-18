#include <bits/stdc++.h>
using namespace std;

int a, b, v;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> a >> b >> v;

    // 하루에 이동 거리 : a - b
    int one_day_step = a - b;
    // 마지막 날 낮에 최소한으로 요구되는 위치
    int minmum_required_height = v - a;
    // 마지막 날 전 날까지 계산
    int day = minmum_required_height / one_day_step;
    if (minmum_required_height % one_day_step != 0)
    {
        day++;
    }
    // 마지막날 계산
    day++;
    cout << day << "\n";
    return 0;
}