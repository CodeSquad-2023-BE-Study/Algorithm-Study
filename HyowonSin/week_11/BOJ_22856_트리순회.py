import sys

N = int(sys.stdin.readline().strip())

graph = [0] * (N+1)
visited = [0] * (N+1)
visited[1] = 1
move = []
stack = []

for _ in range(N):
    n, a, b = map(int, sys.stdin.readline().strip().split(" "))
    graph[n] = [a, b]


def traversal(node):
    if graph[node][0] != -1 and visited[graph[node][0]] == 0:
        stack.append(node)
        move.append(graph[node][0])
        visited[graph[node][0]] = 1
    elif graph[node][1] != -1 and visited[graph[node][1]] == 0:
        stack.append(node)
        move.append(graph[node][1])
        visited[graph[node][1]] = 1
    elif stack[-1] is not None:
        move.append(stack[-1])
        del stack[-1]


node = 1
while sum(visited) < N:
    traversal(node)
    node = move[-1]
print(len(move))