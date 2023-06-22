#include <bits/stdc++.h>
using namespace std;

int _stack[10001];
int n, _size, x;
string input;

vector<string> split(string input, string delimeter) {
    vector<string> res;
    long long pos;
    string token;
    while ((pos = input.find(delimeter)) != (long long) string::npos) {
        token = input.substr(0, pos);
        res.push_back(token);
        input.erase(0, pos + delimeter.size());
    }
    res.push_back(input);
    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    string bufferflush;
    getline(cin, bufferflush);
    for (int i = 0; i < n ; i++) {
        getline(cin, input);
        string command = input.substr(0,2);
        if (command == "pu") {
            x = atoi(split(input, " ")[1].c_str());
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