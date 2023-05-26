#include <bits/stdc++.h>
using namespace std;

vector <int> v;
vector <int> v2;
int main() {
	// 정렬하고 unique + erase
	v = {4, 3, 3 ,5, 1, 2, 3,};
	for (auto it : v) cout << it << " ";
	cout << "\n";
	sort(v.begin(), v.end());
	for (auto it : v) cout << it << " ";
	cout << "\n";
	v.erase(unique(v.begin(), v.end()), v.end()); // erase(start ,end) iterator의 start위치(포함)부터 end위치(포함)까지 지운다.
	for (auto it : v) cout << it << " ";
	cout << "\n";
	// 아래는 정렬 안 하고 unique + erase
	v2 ={4, 3, 3 ,5, 1, 2, 3,}; 
	for (auto it : v2) cout << it << " ";
	cout << "\n";
	for (auto it : v2) cout << it << " ";
	cout << "\n";
	v2.erase(unique(v2.begin(), v2.end()), v2.end()); // erase(start ,end) iterator의 start위치(포함)부터 end위치(포함)까지 지운다.
	for (auto it : v2) cout << it << " ";
	return 0;
}
