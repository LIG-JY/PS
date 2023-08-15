#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int start, int end) {
    vector<int> res(end-start+1);
    iota(res.begin(), res.end(), start);
    return res;
}
