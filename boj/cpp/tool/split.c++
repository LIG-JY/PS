#include <bits/stdc++.h>
using namespace std;

vector<string> split(string input, string delimeter) {
	vector<string> ret;
	long long pos = 0;
	string token = "";
	while ((pos = input.find(delimeter)) != string::npos) {
		token = input.substr(0, pos);
		ret.push_back(token);
		input.erase(0 , pos + delimeter.length());
	}
	ret.push_back(input);
	return ret;
}