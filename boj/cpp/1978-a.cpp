#include <bits/stdc++.h>
using namespace std;

bool isPrime(int num)
{
    std::vector<char> erato;
    for (int i = 0; i <= num; i++)
    {
        erato.push_back(1);
    }

    erato[0] = 0;
    erato[1] = 0;

    for (int i = 2; i * i <= num; i++)
    {
        if (erato[i])
        {
            for (int j = i * i; j <= num; j += i)
            {
                erato[j] = 0;
            }
        }
    }

    return erato[num];
}

int n, _input, answer;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> _input;
        if (isPrime(_input))
        {
            answer++;
        }
    }
    cout << answer;
}