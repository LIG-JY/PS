#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> num_list)
{
	if (num_list.size() < 11)
	{
		return accumulate(num_list.begin(), num_list.end(), 1, multiplies<int>());
	}
	return accumulate(num_list.begin(), num_list.end(), 0);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/181879
