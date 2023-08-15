#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    auto now = time(nullptr);
    auto t = localtime(&now);
    int month = t->tm_mon + 1;
    if (month >= 10) {
        cout << t->tm_year + 1900 << "-" << month << "-" << t->tm_mday;
    } else {
        cout << t->tm_year + 1900 << "-0" << month << "-" << t->tm_mday;
    }
    return 0;
}