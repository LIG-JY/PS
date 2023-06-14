#include<bits/stdc++.h>
using namespace std;

int N, K, num, psum[100001];
int res = -10000000;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> K;
    for (int i = 1; i <= N; i++) {
        cin >> num;
        psum[i] = psum[i - 1] + num; 
    }
    for (int i = 0; i <= N - K; i++) {
        res = max(psum[i + K] - psum[i], res);
    }
    cout << res << "\n";
    return 0;
}