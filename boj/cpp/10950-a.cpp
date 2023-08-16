#include <bits/stdc++.h>

using namespace std;

void sol(string &);

int t;
string bufferflush, input_line;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> t;
    getline(cin, bufferflush);
    while (t--) {
        getline(cin, input_line);
        sol(input_line);
    }
    return 0;
}

void sol(string &s) {
    size_t pos = 0;
    vector<string> temp;
    while ((pos = s.find(' ')) != string::npos) {
        temp.push_back(s.substr(0, pos));
        s.erase(0, pos + 1); // " "의 size는 1
    }
    temp.push_back(s);
    cout << stoi(temp[0]) + stoi(temp[1]) << "\n";
}