import sys


def backtracking(arr, v, n, m):
    if len(arr) == m:
        if printingList.get(tuple(arr)) is not None:
            return
        else:
            print(' '.join(map(str, arr)))
            printingList[tuple(arr)] = 1
            return

    for i in range(1, n + 1):
        if not v[i]:
            v[i] = True
            backtracking(arr + [arrayList[i - 1]], v, n, m)
            v[i] = False


N, M = map(int, sys.stdin.readline().split())
arrayList = list(map(int, sys.stdin.readline().split()))
arrayList.sort()
visited = [False] * (N + 1)
printingList = {}
backtracking([], visited, N, M)
