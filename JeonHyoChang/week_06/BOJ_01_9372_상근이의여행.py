import sys

sys.setrecursionlimit(10 ** 5)

t = int(sys.stdin.readline())

for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    for _ in range(m):
        a, b = map(int, sys.stdin.readline().split())

    print(n - 1)
