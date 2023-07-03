import sys


def backtracking(row, col):
    global count

    if row == N:
        for i in range(N - 1):
            for j in range(M - 1):
                if nemoNemo[i][j] \
                        and nemoNemo[i][j + 1] \
                        and nemoNemo[i + 1][j] \
                        and nemoNemo[i + 1][j + 1]:
                    return

        count += 1
        return

    nextCol = 0 if col + 1 == M else col + 1
    nextRow = row + 1 if nextCol == 0 else row

    nemoNemo[row][col] = True
    backtracking(nextRow, nextCol)

    nemoNemo[row][col] = False
    backtracking(nextRow, nextCol)


N, M = map(int, sys.stdin.readline().split())
nemoNemo = [[False] * M for _ in range(N)]
count = 0

backtracking(0, 0)
print(count)
