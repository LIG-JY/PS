#include <bits/stdc++.h>
using namespace std;

int h, w, t;
string s;
bool isCloudy;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> h >> w;
    for (int i = 0; i < h; i++) {
        isCloudy = false;
        t = 0;
        cin >> s;
        for (char weather : s) {
            if (weather == 'c') {
                t = 0;   
                isCloudy = true;
            }
            else {
                if (isCloudy) {
                    t++;
                }
                else {
                    t = -1;
                }
            }
            cout << t << " ";
        }
        cout << "\n";
    }
    return 0;
}