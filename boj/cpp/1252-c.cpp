#include <bits/stdc++.h>
using namespace std;

string addBinary(const string &a, const string &b)
{
	const int a_len = a.size();
	const int b_len = b.size();
	int carry = 0;			 // 다음 자리 수로 넘어가는 값
	int sum = 0;			 // 각 자리수의 합
	int a_index = a_len - 1; // 가장 오른쪽 자리 수부터 더한다.
	int b_index = b_len - 1;
	string res = "";

	while (b_index >= 0 || a_index >= 0 || carry)
	{
		sum = carry;	  // 이전 자리수에서 넘어온 값으로 초기화 0 + carry는 결과적으로 carry와 동일
		if (a_index >= 0) // a,b 길이가 다르기 때문에 인덱스 벗어나지 않게 확인.
		{
			sum += a[a_index--] - '0';
		}
		if (b_index >= 0)
		{
			sum += b[b_index--] - '0';
		}
		carry = sum / 2;				// sum은 3,2,1,0중 하나이다. 3과 2의 경우 carry를 올린다.
		res = to_string(sum % 2) + res; // push_front -> 성능차이 무의미합니다.
	}
	return res;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string a, b, result;
	cin >> a >> b;

	result = addBinary(a, b);

	size_t non_zero_idx = result.find_first_not_of('0'); // remove leading zero
	if (non_zero_idx != string::npos)
	{
		cout << result.substr(non_zero_idx);
	}
	else
	{
		cout << "0";
	}
	// Memory : 2024KB Running Time : 0ms
}