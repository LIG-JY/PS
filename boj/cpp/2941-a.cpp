#include <bits/stdc++.h>
using namespace std;

string input;
vector<string> table;
int cnt;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    table.push_back("c=");
    table.push_back("c-");
    table.push_back("dz=");
    table.push_back("d-");
    table.push_back("lj");
    table.push_back("nj");
    table.push_back("s=");
    table.push_back("z=");
    cin >> input;
    while (!input.empty())
    {
        if (input.substr(0, 1) == "-" || input.substr(0, 1) == "=")
        {
            input.erase(0, 1);
        }
        else
        {
            if (input.substr(0, 1) == "c")
            {
                if (input.substr(1, 1) == "=")
                {
                    input.erase(0, 2);
                }
                else if (input.substr(1, 1) == "-")
                {
                    input.erase(0, 2);
                }
                else
                {
                    input.erase(0, 1);
                }
            }
            else if (input.substr(0, 1) == "d")
            {
                if (input.substr(1, 2) == "z=")
                {
                    input.erase(0, 3);
                }
                else if (input.substr(1, 1) == "-")
                {
                    input.erase(0, 2);
                }
                else
                {
                    input.erase(0, 1);
                }
            }
            else if (input.substr(0, 1) == "l")
            {
                if (input.substr(1, 1) == "j")
                {
                    input.erase(0, 2);
                }
                else
                {
                    input.erase(0, 1);
                }
            }
            else if (input.substr(0, 1) == "n")
            {
                if (input.substr(1, 1) == "j")
                {
                    input.erase(0, 2);
                }
                else
                {
                    input.erase(0, 1);
                }
            }
            else if (input.substr(0, 1) == "s")
            {
                if (input.substr(1, 1) == "=")
                {
                    input.erase(0, 2);
                }
                else
                {
                    input.erase(0, 1);
                }
            }
            else if (input.substr(0, 1) == "z")
            {
                if (input.substr(1, 1) == "=")
                {
                    input.erase(0, 2);
                }
                else
                {
                    input.erase(0, 1);
                }
            }
            else {
                input.erase(0, 1);
            }
            cnt++;
        }
    }
    cout << cnt << "\n";
    return 0;
}
