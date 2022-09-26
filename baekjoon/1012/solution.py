// [문제 링크]: https://www.acmicpc.net/problem/1012

from collections import deque
​
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
​
​
def bfs(x, y, map):
    queue_ = deque()
    queue_.append((x, y))
    map[x][y] = 0
    while queue_:
        current_x, current_y = queue_.popleft()
        
        for idx in range(4):
            if current_x + dx[idx] < 0 or current_x + dx[idx] >= N or \
                    current_y + dy[idx] < 0 or current_y + dy[idx] >= M:
                continue
            if map[current_x + dx[idx]][current_y + dy[idx]] == 1:
                map[current_x + dx[idx]][current_y + dy[idx]] = 0
                queue_.append((current_x + dx[idx], current_y + dy[idx]))
    return
​
​
​
test = int(input())
for cases in range(test):
    M, N, K = map(int, input().split())
    current_map = [[0] * M for _ in range(N)]
    for _ in range(K):
        x, y = map(int, input().split())
        current_map[y][x] = 1
    count = 0
    for y in range(N):
        for x in range(M):
            if current_map[y][x] == 1:
                bfs(y, x, current_map)
                count += 1
    print(count)