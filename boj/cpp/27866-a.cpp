#include <bits/stdc++.h>
using namespace std;

string input_;
int idx;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(nullptr);
    cin.tie(nullptr);

    cin >> input_;
    cin >> idx;
    cout << input_[idx - 1];
    return 0;
}