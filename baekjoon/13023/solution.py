// [문제 링크]: https://www.acmicpc.net/problem/13023

​
N,M = map(int, input().split())  # 앞의 글자는 n, 뒤의 글자는 m으로 할당됨.
arr = []
​
for _ in range(M): # M번 loop을 돌면서 input을 arr에 append
    arr.append(list(map(int, input().split())))
​
graph_map = {}
for i in range(N):
    graph_map[i] = [] # 지도 key마다 미리 빈 리스트 value만들어 놓기, key의 갯수는 N과 동일하다. number of Vertices
for i in range(M):
    graph_map[arr[i][0]].append(arr[i][1]) # 주어진 입력값대로 지도를 완성합니다.
    graph_map[arr[i][1]].append(arr[i][0])
# Ex) {0: [1, 3], 1: [0, 2, 4], 2: [1, 3], 3: [2, 0], 4: [1]}
​
visited = [False for i in range(N)]
# 방문 확인용 list
​
def dfs(v, depth):
    global ans # 전역변수 선언
    visited[v] = True # 방문한 Vertex를 True로 바꿔 놓는다.
    if depth == 4: # 깊이가 4라면(Edges를 4번 거쳤다면)
        ans = True
        return
    for next_ in graph_map[v]:
        if not visited[next_]:
            dfs(next_, depth+1) # 방문하지 않았다면, 그 점을 방문하고 depth를 증가시킵니다.
            visited[next_] = False # 방문을 끝내고 돌아오면 다시 False로 바꿔줍니다. Backtracking
​
ans = False
# 돌아가면서 dfs의 시작점 설정
for start in range(N):
    dfs(start,0) # 깊이 0으로 시작
    visited[start] = False # 처음 방문한 Vertex까지 False로
    if ans: #ans가 True면 break
        break
print(1 if ans else 0)