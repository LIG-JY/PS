#include <bits/stdc++.h>
using namespace std;

int n;
int main()
{
    cin >> n;

    // 5로 나눠서 시작점을 계산하자.
    int start = n / 5;

    // 몇 봉지인지 계산결과를 저장
    vector<int> cnt_list;
    for (int i = start; i >= 0; i--)
    {
        // 목표무게 : n
        int goal = n - i * 5;
        // 5 * i 를 제외하고 3으로 나눠지는지 여부 확인하면 정확하게 N그램 배달하는지 알 수 있다.
        if (goal % 3 == 0)
        {
            cnt_list.push_back(i + goal / 3);
        }
    }
    // 못 찾는 경우
    if (cnt_list.empty())
    {
        cout << -1 << "\n";
        return 0;
    }
    cout << *min_element(cnt_list.begin(), cnt_list.end());
    return 0;
}