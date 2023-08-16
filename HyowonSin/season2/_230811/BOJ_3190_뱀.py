import sys
from collections import deque

N = int(sys.stdin.readline().strip())
K = int(sys.stdin.readline().strip())

Map = [[0] * (N+2) for _ in range(N+2)]
for i in range(N+2):
    Map[0][i] = 2
    Map[N+1][i] = 2
    Map[i][0] = 2
    Map[i][N+1] = 2

Map[1][1] = 2
head = [1, 1]
tail = deque()
cur_dir = 0
direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]
time = 0
check_time = deque()
next_time = []

for _ in range(K):
    row, column = map(int, sys.stdin.readline().strip().split(' '))
    Map[row][column] = 1

L = int(sys.stdin.readline().strip())

for _ in range(L):
    check_time.append(sys.stdin.readline().strip().split(' '))
next_time = check_time.popleft()

while True:
    newX = head[1] + direction[cur_dir][1]
    newY = head[0] + direction[cur_dir][0]
    if Map[newY][newX] == 2:
        breaker = False
        time += 1
        break
    elif Map[newY][newX] == 1:
        tail.append([head[0], head[1]])
        head[0] = head[0] + direction[cur_dir][0]
        head[1] = head[1] + direction[cur_dir][1]
        Map[head[0]][head[1]] = 2
        time += 1
    else:
        tail.append([head[0], head[1]])
        head[0] = head[0] + direction[cur_dir][0]
        head[1] = head[1] + direction[cur_dir][1]
        Map[head[0]][head[1]] = 2
        d = tail.popleft()
        Map[d[0]][d[1]] = 0
        time += 1

    if str(time) == next_time[0]:
        if next_time[1] == 'L':
            cur_dir = (cur_dir + 3) % 4
        elif next_time[1] == 'D':
            cur_dir = (cur_dir + 1) % 4
        if len(check_time) > 0:
            next_time = check_time.popleft()

print(time)