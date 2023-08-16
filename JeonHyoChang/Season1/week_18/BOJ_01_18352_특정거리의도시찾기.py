import sys

n, m, k, x = map(int, sys.stdin.readline().split())

city = [set() for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    city[a].add(b)

result = {x}
beforeCity = {x}
for _ in range(k):
    temp = result
    result = set()
    for nextCity in temp:
        if len(city[nextCity]) > 0:
            beforeCity.update([nextCity])
            result.update(city[nextCity])
            result -= beforeCity
    beforeCity.update(result)

if len(result) == 0:
    print(-1)
else:
    sortedResult = sorted(result)
    for cityNum in sortedResult:
        print(cityNum)
