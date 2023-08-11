import sys

n, m = map(int, sys.stdin.readline().split())

listen = []
for _ in range(n):
    listen.append(sys.stdin.readline().split()[0])

look = []
for _ in range(m):
    look.append(sys.stdin.readline().split()[0])

intersection = set(listen) & set(look)
result = list(intersection)
result.sort()

print(len(result))
for name in result:
    print(name)
