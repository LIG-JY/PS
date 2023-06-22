#include <bits/stdc++.h>
using namespace std;

stack<int> _stack;
vector<string> splited;
int n, x;
string input, command;

vector<string> split(string org, string delimeter) {
    vector<string> res;
    long long pos;
    string token;
    while ((pos = org.find(delimeter)) != (long long) string::npos) {
        token = org.substr(0,pos);
        res.push_back(token);
        org.erase(0, pos + delimeter.size());
    }
    token = org;
    res.push_back(token);
    return res;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    string bufferflush;
    getline(cin, bufferflush);
    for (int i = 0 ; i < n; i++) {
        getline(cin, input);
        splited = split(input ," ");
        if (splited.size() == 2) {
            x = atoi(splited[1].c_str());
        }
        command = splited[0];
        if (command == "push") {
            _stack.push(x);
        }
        else if (command == "top") {
            if (_stack.empty()) {
                cout << -1 << "\n";
                continue;
            }
            cout << _stack.top() << "\n"; 
        }
        else if (command == "size") {
            cout << _stack.size() << "\n";
        }
        else if (command == "empty") {
            bool isEmpty = _stack.empty();
            if (isEmpty) {
                cout << 1 << "\n";
            }
            else {
                cout << 0 << "\n";
            }
        }
        else if (command == "pop"){
            if (_stack.empty()) {
                cout << -1 << "\n";
            }
            else {
                int output = _stack.top();
                _stack.pop();
                cout << output << "\n";
            }
        }
    } 
}