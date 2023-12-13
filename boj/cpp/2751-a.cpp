#include <bits/stdc++.h>
using namespace std;

int n;
set<int> ordered_set;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    while (n--)
    {
        int input;
        cin >> input;
        ordered_set.insert(input);
    }

    for (const auto &e : ordered_set)
    {
        cout << e << "\n";
    }
    return 0;
}