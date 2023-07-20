import sys
sys.setrecursionlimit(10**9)

N, M, K, X = map(int, sys.stdin.readline().strip().split(' '))

visited = [300001 for _ in range(N+1)]
visited[0] = 0
visited[X] = 0

node = {}
for i in range(N):
    node[i+1] = set()

for i in range(M):
    start, end = map(int, sys.stdin.readline().strip().split(' '))
    node[start].add(end)

def search(node, start, visited, depth):
    if depth > K:
        return
    for i in node[start]:
        if visited[i] > depth:
            visited[i] = depth
            search(node, i, visited, depth + 1)

search(node, X, visited, 1)
answer = []
for i in range(len(visited)):
    if visited[i] == K:
        answer.append(i)

if len(answer) == 0:
    print(-1)
else:
    for i in answer:
        print(i)
