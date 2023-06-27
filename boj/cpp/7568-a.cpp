#include <bits/stdc++.h>
using namespace std;

int n,w,t,ranking[51];
vector<pair<int,int>> people;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> w >> t;
        people.push_back({w, t});        
    }

    fill(&ranking[0], &ranking[0] + 51, 1);

    for (int i = 0; i < n ; i++) {
        for (int j = 0; j < n; j++) {
            if ((people[i].first < people[j].first) && (people[i].second < people[j].second)) {
                ranking[i]++;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        cout << ranking[i] << " ";
    }
}