import sys

N = int(sys.stdin.readline())
coordinate = list()

for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    coordinate.append((x, y))

coordinate.sort(key=lambda c: (c[0], c[1]))

for e in coordinate:
    print(e[0], e[1])
