#include <iostream>
#include <string>

using namespace std;

string a, b;
int temp;

int toSeconds(const string &s);
string toOrigin(int seconds);
void format_num(string &times);

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> a >> b;
	temp = toSeconds(b) - toSeconds(a);
	if (temp < 0)
	{
		temp += 24 * 3600;
	}
	cout << toOrigin(temp) << "\n";
	return 0;
}

int toSeconds(const string &s)
{
	int res = 0;
	res += (int)(s[0] - '0') * 10 * 3600;
	res += (int)(s[1] - '0') * 3600;
	res += (int)((s[3]) - '0') * 10 * 60;
	res += (int)((s[4]) - '0') * 60;
	res += (int)((s[6]) - '0') * 10;
	res += (int)((s[7]) - '0');
	return res;
}

string toOrigin(int seconds)
{
	string hour = to_string(seconds / 3600);
	seconds %= 3600;
	string minute = to_string(seconds / 60);
	seconds %= 60;
	string second = to_string(seconds);
	format_num(hour);
	format_num(minute);
	format_num(second);
	return hour + ":" + minute + ":" + second;
}

void format_num(string &times)
{
	if (times.size() == 1)
	{
		times = "0" + times;
	}
}