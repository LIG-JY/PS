#include <bits/stdc++.h>
using namespace std;
#define fin "48:00"

int n, scores[3], checkTime[3];
bool flag1, flag2;
string team, current, prevTime = "00:00";

int makeSecond(string input) {
    return stoi(input.substr(0,2)) * 60 + stoi(input.substr(3,2));
}

void printT(int seconds) {
    string m = "0" + to_string(seconds / 60);
    string s = "0" + to_string(seconds % 60);
    cout << m.substr(m.size() - 2, 2) << ":" << s.substr(s.size() - 2, 2) << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    while (n--) {
        cin >> team >> current;
        scores[stoi(team)]++;
        if (!flag1 && scores[1] > scores[2]) {
            flag1 = true;
            prevTime = current;
        }
        else if(!flag2 && scores[1] < scores[2]) {
            flag2 = true;
            prevTime = current;
        }
        if (scores[1] == scores[2]) {
            if (flag1) {
                checkTime[1] += (makeSecond(current) - makeSecond(prevTime));
                flag1 = false;
            }
            if (flag2) {
                checkTime[2] += (makeSecond(current) - makeSecond(prevTime));
                flag2 = false;
            }
        }
    }
    if (scores[1] > scores[2]) {
        checkTime[1] += (makeSecond(fin) - makeSecond(prevTime));
    }
    else if(scores[1] < scores[2]) {
        checkTime[2] += (makeSecond(fin) - makeSecond(prevTime));
    }
    for (int i = 1; i < 3; i++) {
        printT(checkTime[i]);
    }
    return 0;
}
