def dynamicArray(n, queries):
    answer = []
    lastAnswer = 0
    arr = [[] for i in range(n)]
    for idx in range(q):
        if queries[idx][0] == 1:
            result = (queries[idx][1] ^ lastAnswer) % n
            arr[result].append(queries[idx][2])
        else:
            result = result = (queries[idx][1] ^ lastAnswer) % n
            lastAnswer = arr[result][queries[idx][2]% len(arr[result])]
            answer.append(lastAnswer)
    return answe

# q 는 설정되어있습니다.r
