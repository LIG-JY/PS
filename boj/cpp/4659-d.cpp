#include <bits/stdc++.h>
using namespace std;

string input;
int v_cnt, c_cnt;

bool isVowel(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (cin >> input && input != "end") {
        bool vFlag = false;
        bool tripleFlag = false;
        bool dupFlag = false;
        v_cnt = c_cnt = 0;;
        char prevC = -1;
        for (char c : input) {
            // 모음 포함
            if (isVowel(c)) {
                vFlag = true;
                v_cnt++;
                c_cnt = 0;
            }
            if (!isVowel(c)) {
                c_cnt++;
                v_cnt = 0;
            }
            if (c_cnt == 3 || v_cnt == 3) {
                tripleFlag = true;
                break;
            }
            if (c == prevC ) {
                if (c == 'e' || c == 'o') {
                    continue;
                }
                dupFlag = true;
                break;
            }
            prevC = c;
        }
        if (vFlag && !dupFlag && !tripleFlag) {
            cout << "<" << input << "> is acceptable." << "\n";
            continue;
        }
        cout << "<" << input << "> is not acceptable." << "\n";
    }
    return 0;
}