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
    map<int, unsigned int> card_map;
    for (int i = 0; i < n; i++)
    {
        int card;
        cin >> card;
        // map에 카드가 있다면
        if (card_map.count(card))
        {
            card_map[card]++;
        }
        else
        {
            card_map[card] = 1;
        }
    }

    cin >> m;
    for (int i = 0; i < m; i++)
    {
        int card;
        cin >> card;
        cout << card_map[card] << " ";
    }
    return 0;
}