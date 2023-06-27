#include <bits/stdc++.h>
using namespace std;

struct person{
    int w, t, rank;
    person(int w, int t) : w(w), t(t), rank(1) {
    
    }

    bool operator < (const person &other) const {
        if (w >= other.w) {
            return false;
        }
        return t < other.t;
    }
};
int n,w,t;
vector<person> people;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> w >> t;
        people.push_back(person(w, t));        
    }

    for (int i = 0; i < n ; i++) {
        for (int j = 0; j < n; j++) {
            if (people[i] < people[j]) {
                people[i].rank++;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        cout << people[i].rank << " ";
    }
}