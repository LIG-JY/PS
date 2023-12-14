#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> cards;
vector<int> combinations;
vector<int> buffer;
void comb(int index);
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    // n : 카드의 개수, m : 목표 숫자
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        int card;
        cin >> card;
        cards.push_back(card);
    }

    // 3개 조합을 구한다.
    comb(0);

    // 출력
    int result = *max_element(combinations.begin(), combinations.end());
    cout << result;
}

// card의 조합을 구한다. index는 0부터 시작
void comb(int start)
{
    if (buffer.size() == 3)
    {
        // 버퍼가 꽉차면 3개의 합을 combinations 리스트에 추가한다.
        // 이 때 m을 넘으면 넣지 않는다.
        int sum = accumulate(buffer.begin(), buffer.end(), 0);
        if (sum <= m)
        {
            combinations.push_back(sum);
        }
        return;
    }
    for (int i = start; i < n; i++)
    {
        int card = cards[i];
        // 1개 담고
        buffer.push_back(card);
        // 조합 재귀호출 : 현재 인덱스 다음 부터 다시 조합하면 된다.
        comb(i + 1);
        // 마지막으로 담은 1개 빼기
        buffer.pop_back();
    }
}