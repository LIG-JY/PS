#include <bits/stdc++.h>
using namespace std;

vector<string> split(string s)
{
    vector<string> res;
    size_t pos = 0;
    while ((pos = s.find(" ")) != string::npos)
    {
        res.push_back(s.substr(0, pos));
        s.erase(0, pos + 1);
    }
    res.push_back(s);
    return res;
}

bool last_check(string s)
{
    vector<string> res = split(s);
    // 0의 개수가 3개면 종료
    return count(res.begin(), res.end(), "0") == 3;
}

bool is_right_triangle(string s)
{
    vector<string> length_list = split(s);
    vector<int> length_vector;
    for (string lenght : length_list)
    {
        length_vector.push_back(stoi(lenght));
    }
    sort(length_vector.begin(), length_vector.end());
    return pow(length_vector[0], 2) + pow(length_vector[1], 2) == pow(length_vector[2], 2);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string input_line;
    while (1)
    {
        getline(cin, input_line);
        if (last_check(input_line))
        {
            break;
        }
        if (is_right_triangle(input_line))
        {
            cout << "right\n";
            continue;
        }
        cout << "wrong\n";
    }
    return 0;
}