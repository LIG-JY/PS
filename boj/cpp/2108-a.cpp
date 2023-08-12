#include <bits/stdc++.h>
using namespace std;

int n, num;
vector<int> num_list;
map<int, int> cnt;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> num;
		num_list.push_back(num);
	}

	// 산술평균 : N개의 수들의 합을 N으로 나눈 값
	double sum = 0;
	for (int i : num_list)
	{
		sum += i;
		cnt[i]++;
	}
	double avg = round(sum / n);
	if (avg == -0)
	{
		cout << 0 << "\n";
	}
	else
	{
		cout << fixed << setprecision(0) << avg << "\n";
	}

	// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
	// 정렬후 중간 인덱스
	sort(num_list.begin(), num_list.end());
	if ((n & 1) == 0)
	{
		cout << (num_list[n / 2] + num_list[n / 2 - 1]) / 2 << "\n";
	}
	else
	{
		cout << num_list[(n - 1) / 2] << "\n";
	}

	// 최빈값 : N개의 수들 중 가장 많이 나타나는 값
	auto it = max_element(cnt.begin(), cnt.end(), [](const auto &a, const auto &b)
						  { return a.second < b.second; });

	int max_f = it->second;
	set<int> temp;
	for (auto i : cnt)
	{
		if (i.second == max_f)
		{
			temp.insert(i.first);
		}
	}

	if (temp.size() == 1)
	{
		cout << *temp.begin() << "\n";
	}
	else
	{
		auto second_e = temp.begin();
		advance(second_e, 1);
		cout << *second_e << "\n";
	}

	// 범위 : N개의 수들 중 최댓값과 최솟값의 차이
	auto max_v_i = num_list.end();
	advance(max_v_i, -1);
	cout << *max_v_i - *num_list.begin() << "\n";
	return 0;
}
