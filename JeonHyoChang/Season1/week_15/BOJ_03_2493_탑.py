import sys

N = int(sys.stdin.readline())
towerHeight = list(map(int, sys.stdin.readline().split()))
result = [0] * N

stack = []
for i in range(N):
    while stack and towerHeight[stack[-1]] < towerHeight[i]:
        stack.pop()

    if stack:
        result[i] = stack[-1] + 1

    stack.append(i)

print(*result)
