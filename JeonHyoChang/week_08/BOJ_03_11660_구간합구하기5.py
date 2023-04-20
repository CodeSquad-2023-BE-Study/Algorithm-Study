import sys

sys.setrecursionlimit(10 ** 5)

n, m = map(int, sys.stdin.readline().split())

table = [[0] * (n + 1)]
for _ in range(n):
    table.append([0] + list(map(int, sys.stdin.readline().split())))

for i in range(1, n + 1):
    for j in range(1, n + 1):
        table[i][j] += table[i - 1][j] + table[i][j - 1] - table[i - 1][j - 1]

xyList = []
for _ in range(m):
    xyList.append(list(map(int, sys.stdin.readline().split())))


def tableSumPrint():
    for listLine in xyList:
        print(tableSum(listLine))


def tableSum(listLine):
    return table[listLine[2]][listLine[3]] \
        - table[listLine[0] - 1][listLine[3]] \
        - table[listLine[2]][listLine[1] - 1] \
        + table[listLine[0] - 1][listLine[1] - 1]


tableSumPrint()
