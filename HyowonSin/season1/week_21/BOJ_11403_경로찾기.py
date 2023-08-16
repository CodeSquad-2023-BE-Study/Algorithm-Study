import sys

N = int(sys.stdin.readline().strip())
graph = []
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip().split(' '))))

node = {}
for i in range(N):
    node[i] = set()
    for j in range(N):
        if graph[i][j] == 1:
            node[i].add(j)

count = 0
result = [0 for _ in range(N)]
while count < N:
    for i in range(N):
        if result[i] == 1:
            continue
        before = node[i]
        for j in node[i]:
            if node[i] != node[j]:
                node[i] = node[i].union(node[j])
        if before == node[i]:
            result[i] = 1
            count += 1

for i in range(N):
    for j in range(N):
        if j in node[i]:
            graph[i][j] = 1

for i in range(N):
    for j in range(N):
        print(graph[i][j], end=' ')
    print()
