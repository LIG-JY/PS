#include<bits/stdc++.h>
using namespace std;

int N, M;
string name, key;
map<string,int> d1;
string d2[100001];
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> M;
    for (int i = 1; i <= N; i++) {
        cin >> name;
        d1[name] = i;
        d2[i] = name;
    }
    for (int i = 1; i <= M; i++) {
        cin >> key;
        if (atoi(key.c_str()) != 0) {
            cout << d2[atoi(key.c_str())] << "\n";
        }
        else {
            cout << d1[key] << "\n";
        }
    }
    return 0;
}