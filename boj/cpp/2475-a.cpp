#include <bits/stdc++.h>
using namespace std;

string s;
vector<int> nums;
int res;
vector<int> split(string input, string del) {
    size_t pos;
    string token = "";
    vector<int> res;
    while ((pos = input.find(del)) != string::npos) {
        token = input.substr(0, pos);
        res.push_back(stoi(token));
        input.erase(0, pos + del.size());
    }
    res.push_back(stoi(input));
    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    getline(cin, s);
    nums = split(s, " ");

    for (int num : nums) {
        res += (num * num);
    }
    cout << res % 10 << "\n";

    return 0;
}