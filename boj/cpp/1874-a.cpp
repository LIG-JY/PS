#include <bits/stdc++.h>
using namespace std;

int n, _input;
vector<int> input_list;
stack<int> _stack;
queue<int> q;
vector<string> output_list;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        // 입력값 담은 리스트
        cin >> _input;
        input_list.push_back(_input);
        // 스택에 push 하는 순서를 구현한 큐
        q.push(i);
    }

    int last_pop = 0;
    for (int input : input_list)
    {
        // case1 : 가장 마지막으로 뽑은 값과 비교해서 큰 경우
        if (last_pop < input)
        {
            // q에서 input을 찾을 수 없는 경우. stack에도 넣을 수 없어서 수열을 완성할 수 없다.
            if (q.empty() || q.front() > input)
            {
                cout << "NO";
                return 0;
            }
            // q에서 순서대로 빼서 stack에 push(뽑을 때 마다 값은 증가)
            while (!q.empty() && q.front() <= input)
            {
                int val = q.front();
                q.pop();
                _stack.push(val);
                output_list.push_back("+");
            }
            // stack에서 input을 꺼내서 수열 만들기
            last_pop = _stack.top();
            _stack.pop();
            output_list.push_back("-");
        }

        // case2 : 가장 마지막으로 뽑은 값과 비교해서 작은 경우, stack에서 계속 뽑아서 찾으면 된다.
        else
        {
            // stack에서 찾을 수 없는 경우
            if (_stack.empty() || _stack.top() < input)
            {
                cout << "NO";
                return 0;
            }
            // 초기값 last_pop은 반드시 stack에 없어야한다.
            int val = last_pop;
            while (!_stack.empty() && val > input)
            {
                val = _stack.top();

                // stack에서 못 찾는 경우(건너 뛰는 경우)
                if (val < input)
                {
                    cout << "NO";
                    return 0;
                }
                _stack.pop();
                output_list.push_back("-");
                // last_pop 갱신
                last_pop = val;
            }
        }
    }

    // output
    for (auto s : output_list)
    {
        cout << s << "\n";
    }
    return 0;
}