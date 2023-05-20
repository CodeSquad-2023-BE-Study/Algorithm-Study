import sys

n = int(sys.stdin.readline())

calendar = [0] * 366
for _ in range(n):
    s, e = map(int, sys.stdin.readline().split())
    for i in range(s, e + 1):
        calendar[i] += 1

row, col, result = 0, 0, 0
for day in calendar:
    if day != 0:
        row = max(row, day)
        col += 1
    else:
        result += row * col
        row, col = 0, 0
result += row * col
print(result)
