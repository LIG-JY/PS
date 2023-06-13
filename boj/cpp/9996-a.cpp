#include <bits/stdc++.h>
using namespace std;

int N;
string pattern, f_name, prefix, suffix;
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    cin >> N;
    cin >> pattern;  
    int pos = pattern.find('*');  
    prefix = pattern.substr(0, pos); 
    suffix = pattern.substr(pos + 1); 
    for(int i = 0; i < N; i++){
        cin >> f_name; 
        if(prefix.size() + suffix.size() > f_name.size()){
            cout << "NE\n";
        }else{
            if(prefix == f_name.substr(0, prefix.size()) && suffix == f_name.substr(f_name.size() - suffix.size())) cout << "DA\n";
            else cout <<"NE\n";  
        } 
    } 
    return 0;
} 