#include <bits/stdc++.h>
using namespace std;

map<char, int> voweltable;
string s;
int c_cnt, v_cnt;

bool checkFun(string s) {
    bool containVowel = false;
    bool triple = false;
    bool dup = false;

    c_cnt = v_cnt = 0;
    char prevC = -1;
    for (char c : s) {
        if (!containVowel && voweltable[c]) {
            containVowel = true;
        }
        if (voweltable[c]) {
            v_cnt++;
            c_cnt = 0;
        }
        if (!voweltable[c]) {
            c_cnt++;
            v_cnt = 0;
        }
        if (c_cnt == 3 || v_cnt == 3) {
            triple = true;
            break;
        }
        if ((c == prevC) && (c != 'e' && c != 'o')) {
            dup = true;
            break;
        }
        prevC = c;
    }
    return containVowel && !triple && !dup;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (char i = 'a'; i <= 'z'; i++) {
        if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
            voweltable[i] = 1;
            continue;
        }
        voweltable[i] = 0;
    } //table setting

    // for (auto e : voweltable) {
    //     cout << e.first << e.second << "\n";
    // }

    while (cin >> s) {
        if (s == "end") {
            break;
        }
        if (checkFun(s)) {
            cout << "<" << s << "> is acceptable." << "\n";
            continue;
        }
        cout << "<" << s << "> is not acceptable." << "\n";
    }
    return 0;
}