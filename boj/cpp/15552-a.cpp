#include <bits/stdc++.h>

using namespace std;

int t;
string bf, tc;

void split(string &input, const string &delimiter) {
    deque<string> res;
    size_t pos;

    while ((pos = input.find(delimiter)) != string::npos) {
        res.push_back(input.substr(0, pos));
        input.erase(0, pos + delimiter.size());
    }
    res.push_back(input);

    cout << stoi(res.front()) + stoi(res.back()) << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> t;
    getline(cin, bf);
    while (t--) {
        getline(cin, tc);
        split(tc, " ");
    }
    return 0;
}