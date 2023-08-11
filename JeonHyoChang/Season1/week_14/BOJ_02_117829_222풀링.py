import sys

n = int(sys.stdin.readline())

array = []
for _ in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    array.append(row)


def divide(x, arr):
    tempA = []
    for i in range(0, x, 2):
        tempB = []
        for j in range(0, x, 2):
            tempC = [arr[i][j], arr[i][j + 1], arr[i + 1][j], arr[i + 1][j + 1]]
            tempC.sort(reverse=True)
            tempB.append(tempC[1])
        tempA.append(tempB)

    if x == 2:
        print(tempA[0][0])
    else:
        divide(x // 2, tempA)


divide(n, array)
