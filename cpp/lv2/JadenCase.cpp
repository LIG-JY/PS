#include <string>
#include <vector>

using namespace std;
bool isNextUp = true;

string solution(string s) {
    string answer = "";
    for (auto c : s) {
        if (isspace(c)) {
            answer += c;
            isNextUp = true;
        }
        else {
            char token = (isNextUp ? toupper(c) : tolower(c));
            answer += token;
            isNextUp = false;
        }
    }
    return answer;
}
