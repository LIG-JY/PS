#include <bits/stdc++.h>
using namespace std;

int n;
deque<int> deq;
string s;

vector<string> split(string input, string del) {
    vector<string> res;
    string token = "";
    long long pos;
    while ((pos = input.find(del)) != string::npos) {
        token = input.substr(0, pos);
        res.push_back(token);
        input.erase(0, pos + del.size());
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
    vector<string> command;
    while (n--) {
        getline(cin, s);
        command = split(s, " ");
        if (command[0].compare("push_front") == 0) {
            int val = stoi(command[1]);
            deq.push_front(val);
        }
        else if (command[0].compare("push_back") == 0) {
            int val = stoi(command[1]);
            deq.push_back(val);
        }
        else if (command[0].compare("pop_front") == 0) {
            if (deq.empty()) {
                cout << -1 << "\n";
                continue;
            }
            int val = deq.front();
            cout << val << "\n";
            deq.pop_front();
        }
        else if (command[0].compare("pop_back") == 0) {
            if (deq.empty()) {
                cout << -1 << "\n";
                continue;
            }
            int val = deq.back();
            cout << val << "\n";
            deq.pop_back();
        }
        else if (command[0].compare("size") == 0) {
            cout << deq.size() << "\n";    
        }
        else if (command[0].compare("empty") == 0) {
            cout << deq.empty() << "\n";    
        }
        else if (command[0].compare("front") == 0) {
            cout << (!deq.empty() ? deq.front() : -1) << "\n";    
        }
        else if (command[0].compare("back") == 0) {
            cout << (!deq.empty() ? deq.back() : -1) << "\n";    
        }
    }
    return 0;
}
