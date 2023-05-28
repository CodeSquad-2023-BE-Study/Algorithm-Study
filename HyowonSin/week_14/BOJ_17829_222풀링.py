import sys

N = int(sys.stdin.readline().strip())

MAP = []
for _ in range(N):
    MAP.append(list(map(int, sys.stdin.readline().strip().split(" "))))


def pooling(MAP):
    M = len(MAP)
    if M == 1:
        print(MAP[0][0])
        return
    new_MAP = []
    for i in range(M//2):
        temp1 = []
        for j in range(M//2):
            temp2 = []
            temp2.append(MAP[i*2][j*2])
            temp2.append(MAP[i*2][j*2+1])
            temp2.append(MAP[i*2+1][j*2])
            temp2.append(MAP[i*2+1][j*2+1])
            temp1.append(sorted(temp2, reverse=True)[1])
        new_MAP.append(temp1)
    pooling(new_MAP)


pooling(MAP)
