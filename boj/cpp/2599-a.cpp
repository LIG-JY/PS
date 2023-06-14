#include<bits/stdc++.h>
using namespace std;

int N, K, num;
vector<int> temperatures;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> K;
    for (int i = 0; i < N; i++) {
        cin >> num;
        temperatures.push_back(num);
    }
    int sum = 0;
    for (int i = 0; i < K; i++) {
        sum += temperatures[i];
    }
    int ret = -10000000;
    ret = max(sum, ret);
    for (int j = K; j < N; j++) {
        sum = sum + temperatures[j] - temperatures[j - K];
        ret = max(sum, ret);
    }
    cout << ret << "\n";
}