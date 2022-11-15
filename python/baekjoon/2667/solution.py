// [문제 링크]: https://www.acmicpc.net/problem/2667

from collections import deque
​
​
N = int(input()) # 첫번째 줄에는 지도의 크기가 입력됩니다.
​
original_map = []
for i in range(N): # 그 다음 N줄에는 각각 N개의 자료 (0혹은 1)가 입력된다.
    original_map.append(list(map(int, input()))) # 2중 리스트 형태로 지도를 입력받습니다.
​
dx = [1, -1, 0, 0] # 우 좌 하 상, dfs함수에 사용할 예정입니다.
dy = [0, 0, 1, -1]
​
​
def bfs(i, j):  # 초기 좌표
    queue_ = deque()  # deque 객체를 생성합니다.
    queue_.append((i, j))  # 좌표를 deque에 넣어줍니다.
    count = 0  # 개수 세기용 변수를 초기화합니다.
    while queue_:  # deque가 빌 때 까지 loop를 돕니다.
        current_i, current_j = queue_.popleft()  # queue의 가장 우선순위, 맨 왼쪽을 대기열에서 뽑습니다.
        if original_map[current_i][current_j] == 1:  # 1인 경우 즉 집이 있는경우 graph traversal을 시작합니다.
            original_map[current_i][current_j] = 0  # 방문을 하고 다시 방문하지 않기 위해서 0으로 바꿔줍니다.
            count += 1  # 집 개수를 더해줍니다.
            for _ in range(4):
                ni, nj = current_i + dx[_], current_j + dy[_]
                if ni < 0 or ni >= N or nj < 0 or nj >= N:  # 좌표가 지도 범위 밖을 벗어나면 다시 반복문의 처음으로 돌아갑니다. 즉 이 좌표는 큐에 넣지 않습니다.
                    continue
                queue_.append((ni, nj))  # 좌표가 지도 범위 밖이 아니라면 큐 대기열에 넣습니다.
    return count
​
​
ans = []
for i in range(N): # 0 ~ N-1, 좌표 i
    for j in range(N): # 좌표 j
        count_ = bfs(i, j)
        if count_ > 0:
            ans.append(count_)
ans.sort()
complex_count = len(ans) # 총 단지수 계산
print(complex_count)
for i, v in enumerate(ans):
    print(v)