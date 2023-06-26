#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
long long min_v;
long long max_v;
vector<string> split(string org, string del) {
    vector<string> res;
    string token = "";
    long long pos;
    while ((pos = org.find(del)) != string::npos) {
        token = org.substr(0, pos);
        res.push_back(token);
        org.erase(0, pos + del.size());
    }
    res.push_back(org);
    return res;
}

string solution(string s) {
    vector<string> arr = split(s, " ");
    vector<long long> nums;
    for (auto s : arr) {
        nums.push_back(stoll(s));
    }
    min_v = *min_element(nums.begin(), nums.end());
    max_v = *max_element(nums.begin(), nums.end());
    string answer = to_string(min_v) + " " + to_string(max_v);
    return answer;
}
