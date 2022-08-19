// [문제 링크]: https://school.programmers.co.kr/learn/courses/30/lessons/118666?language=python3

def scoreboard(surveys, choices):
    score = dict()
    categories = ['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N']
    for i in range(len(categories)):
        score[categories[i]] = 0

    for i in range(len(choices)):
        if choices[i] > 4:
            score[surveys[i][1]] += choices[i] - 4
        elif choices[i] < 4:
            score[surveys[i][0]] += 4 - choices[i]
    return score

def solution(survey, choices):
    answer = ''
    sb = scoreboard(survey, choices)
    mbti = {1: ['R', 'T'], 2: ['C', 'F'], 3: ['J', 'M'], 4: ['A', 'N']}
    for key in mbti:
        first = mbti[key][0]
        second = mbti[key][1]
        if sb[first] > sb[second]:
            answer = answer + first
        elif sb[first] < sb[second]:
            answer = answer + second
        else:
            temp = [first,second]
            temp.sort()
            answer = answer + temp[0]
    return answer