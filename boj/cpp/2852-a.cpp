#include <bits/stdc++.h>
using namespace std;
#define fin "48:00"

int n, scores[3], checkTime[3];
string team, current, prevTime = "00:00";

int makeSecond(string input) {
    return stoi(input.substr(0,2)) * 60 + stoi(input.substr(3,2));
}

void printT(int seconds) {
    string m = "";
    string s = "";
    int mv = seconds / 60;
    int ms = seconds % 60;
    if (mv < 10) {
        m = "0" + to_string(mv);
    }
    else {
        m = to_string(mv);
    }
    if (ms < 10) {
        s = "0" + to_string(ms);
    }
    else {
        s = to_string(ms);
    }
    cout << m << ":" << s << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    while (n--) {
        cin >> team >> current;
        if (scores[1] > scores[2]) {
            checkTime[1] += (makeSecond(current) - makeSecond(prevTime));
        }
        else if(scores[1] < scores[2]) {
            checkTime[2] += (makeSecond(current) - makeSecond(prevTime));
        }
        scores[stoi(team)]++;
        prevTime = current;
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
