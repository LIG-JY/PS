// [문제 링크]: https://www.acmicpc.net/problem/2667

N = int(input()) # 첫번째 줄에는 지도의 크기가 입력됩니다.
​
original_map = []
for i in range(N): # 그 다음 N줄에는 각각 N개의 자료 (0혹은 1)가 입력된다. 
    original_map.append(list(map(int, input()))) # 2중 리스트 형태로 지도를 입력받습니다.
​
dx = [1, -1, 0, 0] # 우 좌 하 상, dfs함수에 사용할 예정입니다.
dy = [0, 0, 1, -1]
​
def dfs(i,j):
    if i < 0 or i >= N or j < 0 or j >= N: # 종료조건: 지도 범위를 벗어나면 종료합니다.
        return False
​
    if original_map[i][j] == 1:
        global count # 함수 밖의 변수에 영향을 미칩니다.
        count += 1 # 단지의 집의 개수를 세기 위해서 count 전역변수로 설정합니다.
        original_map[i][j] = 0 # 방문하고 값을 0으로 바꿔줍니다. 중복으로 세는 것, 방문하는 것을 막을 수 있습니다.
        for _ in range(4): # 우 좌 하 상을 모두 돌기 위해서 for문을 사용합니다.
            dfs(i + dx[_], j + dy[_]) # count가 global이기 때문에 누적해서 합을 계산할 수 있습니다.
        return True# 갈 수 있는 우 좌 하 상를 재귀로 호출하고 return으로 함수를 끝냅니다. 최종적으로 같은 단지의 집을 모두 탐사하면 가장 먼저 호출한 dfs 실행이 종료됩니다.
    return False # 방문한 정사각형에 집이 없으면 함수 종료합니다. if orginal_map[i][j] == 0
    
ans = []
count = 0
for i in range(N): # 0 ~ N-1, 좌표 i
    for j in range(N): # 좌표 j
        if dfs(i,j):
            ans.append(count)
            count = 0 # count 초기화
ans.sort() # 오름차순 정렬
complex_count = len(ans) # 총 단지수 계산
print(complex_count)
for i,v in enumerate(ans):
    print(v)