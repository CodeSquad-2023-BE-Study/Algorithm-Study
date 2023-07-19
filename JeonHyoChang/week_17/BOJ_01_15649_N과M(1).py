import sys


def backtracking(arr, v, n, m):
    if len(arr) == m:
        print(' '.join(map(str, arr)))
        return

    for i in range(1, n + 1):
        if not v[i]:
            v[i] = True
            backtracking(arr + [i], v, n, m)
            v[i] = False


N, M = map(int, sys.stdin.readline().split())
visited = [False] * (N + 1)
backtracking([], visited, N, M)
