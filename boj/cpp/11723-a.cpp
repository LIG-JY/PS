#include <bits/stdc++.h>

using namespace std;

set<int> s, temp;
int t, num;
string cmd;

void go() {
    cin >> cmd;
    if (cmd == "add") {
        cin >> num;
        s.insert(num);
    } else if (cmd == "remove") {
        cin >> num;
        s.erase(num);
    } else if (cmd == "check") {
        cin >> num;
        if (s.count(num)) {
            cout << 1 << "\n";
        } else {
            cout << 0 << "\n";
        }
    } else if (cmd == "toggle") {
        cin >> num;
        if (s.count(num)) {
            s.erase(num);
        } else {
            s.insert(num);
        }
    } else if (cmd == "all") {
        s = temp;
    } else if (cmd == "empty") {
        s.clear();
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    for (int i = 1; i <= 20; i++) {
        temp.insert(i);
    }

    cin >> t;
    while (t--) {
        go();
    }

    return 0;
}