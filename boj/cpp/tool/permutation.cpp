#include<bits/stdc++.h>
using namespace std;
int a[9] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
int n = 9, r = 4;
void print() {
	for(int i = 0; i < r; i++) {
		cout << a[i] << " ";
	}
	cout << "\n";
}
void makePermutation(int n, int r, int depth) {
	if (r == depth) {
		print();
		return;
	}
	for (int i = depth; i < n; i++) {
		swap(a[i], a[depth]);
		cout << "i : " << i << " depth : " << depth << "\n";
		makePermutation(n, r ,depth + 1);
		swap(a[i], a[depth]);
	}
	return;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	makePermutation(n, r, 0);
    return 0;
}