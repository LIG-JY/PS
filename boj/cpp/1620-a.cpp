#include<bits/stdc++.h>
using namespace std;

int N, M;
string name, key;
map<string,string> d1;
map<string,string> d2;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> M;
    for (int i = 1; i <= N; i++) {
        cin >> name;
        d1[name] = to_string(i);
        d2[to_string(i)] = name;
    }
    for (int i = 1; i <= M; i++) {
        cin >> key;
        if (d1.find(key) != d1.end()) {
            cout << d1[key] << "\n";
        }
        if (d2.find(key) != d2.end()) {
            cout << d2[key] << "\n";
        }
    }
    return 0;
}