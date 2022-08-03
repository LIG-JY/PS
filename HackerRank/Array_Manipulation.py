def arrayManipulation(n, queries):
    dict = {}
    for i in range(1, n+1):
        dict[i] = 0
    for query in queries:
        for key in range(query[0],query[1]+1):
            dict[key] = dict[key] + query[2]
    return max(dict.values())

### Fail ###

def arrayManipulation(n, queries):
    arr = [0 for i in range(n+1)]
    for query in queries:
        up = query[0]-1
        down = query[1]
        arr[up] = arr[up] + query[2]
        arr[down] = arr[down] - query[2]
        
    maxanswer = -1
    currentlocation = 0
    for height in arr:
        currentlocation = currentlocation + height
        if currentlocation > maxanswer:
            maxanswer = currentlocation
    return maxanswer

### Success ### 
