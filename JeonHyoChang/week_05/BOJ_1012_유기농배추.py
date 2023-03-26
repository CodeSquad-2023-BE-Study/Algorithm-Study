import sys
sys.setrecursionlimit(10**7)

t = int(sys.stdin.readline())


def dfs_def(x, y):
    if x < 0 or x >= n or y < 0 or y >= m:
        return False
    if cabbageList[y][x] == 1:
        cabbageList[y][x] = 0
        dfs_def(x - 1, y)
        dfs_def(x, y - 1)
        dfs_def(x, y + 1)
        dfs_def(x + 1, y)
        return True
    return False


for _ in range(t):
    n, m, k = map(int, sys.stdin.readline().split())
    cabbageList = [[0] * n for _ in range(m)]

    for _ in range(k):
        num01, num02 = map(int, sys.stdin.readline().split())
        cabbageList[num02][num01] = 1

    c = 0
    for i in range(n):
        for j in range(m):
            if dfs_def(i, j):
                c += 1

    print(c)
