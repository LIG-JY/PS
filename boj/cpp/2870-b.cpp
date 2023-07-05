#include <bits/stdc++.h>
using namespace std;

int n;
string input;
vector<string> res;

bool cmp(const string& a, const string& b) {
    if (a.size() == b.size()) {
        return a < b;
    }
    return a.size() < b.size();
}

void putToken(string token) {
    char c = token[0]; // *token.begin()
    while (token.size() > 1 && c == '0') {
        token.erase(token.begin()); // erase(1);
        c = token[0];
    }
    res.push_back(token);
    return;
}

void play(string s) {
    string token = "";
    int range = s.size();
    for (int i = 0; i < range; i++) {
        char c = s[i];
        if (c >= '0' && c <= '9') {
            token += c;
            if (i == range - 1) {
                putToken(token);
            }
            continue;
        }
        if (!token.empty()) {
            putToken(token);
        }
        token = "";
    }
    return;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        play(input);
    }
    sort(res.begin(), res.end(), cmp);
    for (auto num : res) {
        cout << num << "\n";
    }
    return 0;
}