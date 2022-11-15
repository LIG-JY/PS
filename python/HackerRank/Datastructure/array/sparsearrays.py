def matchingStrings(strings, queries):
    answer = []
    for query in queries:
        answer.append(strings.count(query))
    return answer
