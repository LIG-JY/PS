#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> answer;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = n; i > 0; i--)
    {
        int res = i;
        int div = res;
        while (div)
        {
            res += (div % 10);
            div /= 10;
        }
        if (res == n)
        {
            answer.push_back(i);
        }
    }
    cout << (answer.empty() ? 0 : *min_element(answer.begin(), answer.end()));
    return 0;
}