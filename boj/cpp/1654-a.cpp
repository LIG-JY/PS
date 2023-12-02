#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll n, k;
vector<ll> _list;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> k >> n;

    ll _input;
    while (k--)
    {
        cin >> _input;
        _list.push_back(_input);
    }

    // upper bound
    ll ub = *max_element(_list.begin(), _list.end());
    // lower_bound
    ll lb = 1;
    ll _max = 0;
    while (lb <= ub)
    {
        // calc mid
        ll mid = (ub + lb) / 2;

        // cnt of 랜선
        ll cnt = 0;
        for (ll e : _list)
        {
            cnt += (e / mid);
        }

        // check condition
        if (cnt < n) // cannot make n
        {
            // find shorter length
            // change upper bound
            ub = mid - 1;
            continue;
        }

        // set max
        _max = mid;

        // find longer length
        // change lower bound
        lb = mid + 1;
    }

    cout << _max;
    return 0;
}