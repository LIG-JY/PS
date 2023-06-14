#include <bits/stdc++.h>
using namespace std;

vector<string> split(string input, string delimeter) {
    int pos;
    vector<string> res;
    string token;
    while ((pos = input.find(delimeter)) != string::npos) {
        token = input.substr(0, pos);
        res.push_back(token);
        input.erase(0, pos + delimeter.size());
    }
    res.push_back(input);
    return res;
}
int N;
string pattern, f_name, prefix, suffix;
vector<string> res;
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    cin >> N;
    cin >> pattern;  
    res = split(pattern, "*");
    prefix = res.front(); 
    suffix = res.back(); 
    for(int i = 0; i < N; i++){
        cin >> f_name; 
        bool match = (prefix.size() + suffix.size() <= f_name.size()) &&
                     (prefix == f_name.substr(0, prefix.size())) &&
                     (suffix == f_name.substr(f_name.size() - suffix.size()));
        cout << (match ? "DA" : "NE") << "\n";
    } 
    return 0;
}