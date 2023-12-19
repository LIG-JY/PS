#include <bits/stdc++.h>
using namespace std;

int n;

struct person
{
    int age;
    string name;
};

// stable_sort를 사용하기 위해 compare 함수를 정의한다. 이 때 const를 사용해야 한다.
bool compare(const person &a, const person &b)
{
    return a.age < b.age;
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    vector<person> members(n);
    for (int i = 0; i < n; i++)
    {
        cin >> members[i].age >> members[i].name;
    }
    stable_sort(members.begin(), members.end(), compare);

    for (int i = 0; i < n; i++)
    {
        cout << members[i].age << " " << members[i].name << "\n";
    }
    return 0;
}