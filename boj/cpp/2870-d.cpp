#include <bits/stdc++.h>
using namespace std;

int n;
string input;
string token = "";
vector<string> res;

bool cmp(string& a, string& b) {
    if (a.size() == b.size()) {
        return a < b;
    }
    return a.size() < b.size();
}

void homework(string& token) {
    while (token.size() > 1 && token.front() == '0') {
        // token = token.substr(1);
        token.erase(token.begin());
    }
    res.push_back(token);
    token.clear();
    return;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    while (n--) {
        cin >> input;
        for (char c : input) {
            if (c >= '0' && c <= '9') {
                token += c;
                continue;
            }
            if (!token.empty()) {
                homework(token);
            }           
        }
        if (!token.empty()) {
            homework(token);
        }
    }
    sort(res.begin(), res.end(), cmp);
    for (auto e : res) {
        cout << e << "\n";
    }
    return 0;
}