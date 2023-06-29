#include <bits/stdc++.h>
using namespace std;

int n, idx, deq[10001];
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
            if (idx == 10000) {
                continue;
            }
            for (int i = idx; i > 0; i--) {
                deq[i] = deq[i - 1];
            }
            int val = stoi(command[1]);
            deq[0] = val;
            idx++;
        }
        else if (command[0].compare("push_back") == 0) {
            if (idx == 10000) {
                continue;
            }
            int val = stoi(command[1]);
            deq[idx] = val;
            idx++;
        }
        else if (command[0].compare("pop_front") == 0) {
            if (idx == 0) {
                cout << -1 << "\n";
                continue;
            }
            int val = deq[0];
            cout << val << "\n";
            for (int i = 0; i < idx; i++) {
                deq[i] = deq[i + 1];
            }
            idx--;
        }
        else if (command[0].compare("pop_back") == 0) {
            if (idx == 0) {
                cout << -1 << "\n";
                continue;
            }
            int val = deq[idx - 1];
            cout << val << "\n";
            idx--;
        }
        else if (command[0].compare("size") == 0) {
            cout << idx << "\n";    
        }
        else if (command[0].compare("empty") == 0) {
            cout << (idx ? 0 : 1) << "\n";    
        }
        else if (command[0].compare("front") == 0) {
            cout << (idx ? deq[0] : -1) << "\n";    
        }
        else if (command[0].compare("back") == 0) {
            cout << (idx ? deq[idx - 1] : -1) << "\n";    
        }
    }
    return 0;
}
