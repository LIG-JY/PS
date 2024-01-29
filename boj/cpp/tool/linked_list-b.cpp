#include <bits/stdc++.h>
using namespace std;

const int MX = 1000005;
int value[MX], pre[MX], nxt[MX];
int unused = 1;
int len = 0;
int last_addr = 0;

void insert(int addr, int num)
{
	int pre_addr = addr;
	int next_addr = nxt[addr];

	value[unused] = num;
	pre[unused] = addr;
	nxt[unused] = nxt[addr];
	if (next_addr != -1) pre[next_addr] = unused;
	else last_addr = unused;
	nxt[pre_addr] = unused;
	unused++;
	len++;
}

void erase(int addr)
{
	int pre_addr = pre[addr];
	int next_addr = nxt[addr];

	nxt[pre_addr] = next_addr;
	if (next_addr != -1) pre[next_addr] = pre_addr;
	else last_addr = pre_addr;
	len--;
}

void traverse() {
	int cur = nxt[0];
	while (cur != -1) {
		cout << value[cur] << ' ';
		cur = nxt[cur];
	}
	cout << "\n\n";
}

int find_first_addr() {
	cout << "****** first *****\n";
	cout << "first: " << value[nxt[0]] << '\n';
	return nxt[0];
}

int find_last_addr() {
	cout << "****** last *****\n";
	cout << "last: " << value[last_addr] << '\n';
	return last_addr;
}

void insert_test() {
	cout << "****** insert_test *****\n";
	insert(0, 10); // 10(address=1)
	traverse();
	insert(0, 30); // 30(address=2) 10
	traverse();
	insert(2, 40); // 30 40(address=3) 10
	traverse();
	insert(1, 20); // 30 40 10 20(address=4)
	traverse();
	insert(4, 70); // 30 40 10 20 70(address=5)
	traverse();
}

void erase_test() {
	cout << "****** erase_test *****\n";
	erase(1); // 30 40 20 70
	traverse();
	erase(2); // 40 20 70
	traverse();
	erase(4); // 40 70
	traverse();
	erase(5); // 40
	traverse();
}

int main(void) {
	fill(pre, pre + MX, -1);
	fill(nxt, nxt + MX, -1);
	insert_test();
	erase_test();
}




