#include "is_prime.hpp"
#include <iostream>

bool isPrime(int num)
{
	std::vector<bool> erato;
	for (int i = 0; i <= num; i++)
	{
		erato.push_back(true);
	}

	erato[0] = erato[1] = false;

	// 에라토스테네스의 체
	for (int i = 2; i * i <= num; i++)
	{
		if (erato[i])
		{
			for (int j = i * i; j <= num; j += i)
			{
				erato[j] = false;
			}
		}
	}

	return erato[num];
}