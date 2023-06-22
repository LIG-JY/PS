#include <bits/stdc++.h>
using namespace std;

int _stack[10001];
int n, _size, x;
string input;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    string bufferflush;
    getline(cin, bufferflush);
    for (int i = 0; i < n ; i++) {
        cin >> input;
        string command = input.substr(0,2);
        if (command == "pu") {
            cin >> x;
            _stack[_size++] = x;
        }
        else if (command == "po") {
            cout << ((!_size) ? -1 : _stack[--_size]) << "\n";
        }
        else if (command == "si") {
            cout << _size << "\n";
        }
        else if (command == "em") {
            cout << ((!_size) ? 1 : 0) << "\n";
        }
        else if (command == "to") {
            cout << ((!_size) ? -1 : _stack[_size - 1]) << "\n";
        }
    }
}