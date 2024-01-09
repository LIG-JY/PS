#include <bits/stdc++.h>
using namespace std;

int cnt[26];
string s;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> s;
    for (char c : s)
    {
        cnt[(int)(c - 'a')]++;
    }

    for (int e : cnt)
    {
        cout << e << " ";
    }

    return 0;
}
