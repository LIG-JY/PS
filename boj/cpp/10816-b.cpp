#include <bits/stdc++.h>
using namespace std;

int n, m;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    // 상근이가 가지고 있는 카드들
    int cards[n];
    for (int i = 0; i < n; i++)
    {
        cin >> cards[i];
    }
    sort(cards, cards + n);

    cin >> m;
    for (int i = 0; i < m; i++)
    {
        int card;
        cin >> card;
        // 이분 탐색 후 이터레이터를 이용해 두 인데스 사이 원소 개수 출력
        cout << upper_bound(cards, cards + n, card) - lower_bound(cards, cards + n, card) << " ";
    }
    return 0;
}