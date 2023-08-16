#include <bits/stdc++.h>

using namespace std;


void go(string &line);

string input;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    while (getline(cin, input)) {
        go(input);
    }

    return 0;
}

void go(string &line) {
    vector<string> res;
    size_t pos;
    while ((pos = line.find(' ')) != string::npos) {
        res.push_back(line.substr(0, pos));
        line.erase(0, pos + 1);
    }
    res.push_back(line);
    cout << stoi(res[0]) + stoi(res[1]) << "\n";
}
