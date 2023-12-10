#include "get_count_of_prime_factor.hpp"

// get count of prime factor
int get_count_of_prime_factor(int n, const int prime_factor)
{
	int cnt = 0;
	// calculate cnt of prime factor
	while (n % prime_factor == 0)
	{
		cnt++;
		n /= prime_factor;
	}
	return cnt;
}