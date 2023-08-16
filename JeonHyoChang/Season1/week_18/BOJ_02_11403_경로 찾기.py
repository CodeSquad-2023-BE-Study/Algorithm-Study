import sys


def dfs(graph, start, visited):
    for i in range(len(graph[start])):
        if graph[start][i] == 1 and not visited[i]:
            visited[i] = 1
            dfs(graph, i, visited)


N = int(sys.stdin.readline())
G = []
for _ in range(N):
    row = list(map(int, sys.stdin.readline().split()))
    G.append(row)

result = [[0] * N for _ in range(N)]
for i in range(N):
    V = [0] * N
    dfs(G, i, V)
    result[i] = V

for x in result:
    print(' '.join(str(y) for y in x))
