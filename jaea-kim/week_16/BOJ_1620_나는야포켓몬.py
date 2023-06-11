import sys

n, m = map(int, sys.stdin.readline().split())
by_id = {}
by_name = {}
for i in range(1, n + 1):
    pokemon = input()
    by_id[i] = pokemon
    by_name[pokemon] = i

for _ in range(m):
    x = sys.stdin.readline().rstrip()
    if x.isdigit():
        print(by_id[int(x)])
    else:
        print(by_name[x])
