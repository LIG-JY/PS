#include <bits/stdc++.h>
using namespace std;

int input, i;
vector<int> nums;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while(cin >> input) {
        nums.push_back(input);
    }
    auto i = max_element(nums.begin(), nums.end());
    cout << *i << "\n";
    cout << (int)(i - nums.begin()) + 1 << "\n";
}