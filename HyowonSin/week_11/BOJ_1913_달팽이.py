import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

# 아래로, 오른쪽으로, 위로, 왼쪽으로
# [-1,0], [0, 1], [1, 0], [0, -1]
direction = 0
map = [[0]*N for i in range(N)]

nextNumber = N**2

x = 0
y = 0
target = []

while nextNumber > 0:
    map[y][x] = nextNumber
    if nextNumber == M:
        target.append(y)
        target.append(x)

    if nextNumber == 1:
        break

    if direction == 0:
        if y < N-1 and map[y+1][x] == 0:
            y += 1
            nextNumber -= 1
        else:
            direction = (direction + 1) % 4
    elif direction == 1:
        if x < N-1 and map[y][x+1] == 0:
            x += 1
            nextNumber -= 1
        else:
            direction = (direction + 1) % 4
    elif direction == 2:
        if y > 0 and map[y-1][x] == 0:
            y -= 1
            nextNumber -= 1
        else:
            direction = (direction + 1) % 4
    elif direction == 3:
        if x > 0 and map[y][x-1] == 0:
            x -= 1
            nextNumber -= 1
        else:
            direction = (direction + 1) % 4
for i in range(N):
    for j in range(N):
        print(map[i][j], end=" ")
    print()
print(target[0]+1, target[1]+1)