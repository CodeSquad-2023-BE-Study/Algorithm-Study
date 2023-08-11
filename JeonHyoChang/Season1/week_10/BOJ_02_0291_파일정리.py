import sys

sys.setrecursionlimit(50001)
n = int(sys.stdin.readline())

extensions = {}
for _ in range(n):
    temp = sys.stdin.readline().split('.')[1][:-1]
    if extensions.get(temp) is not None:
        extensions[temp] += 1
    else:
        extensions[temp] = 1

result = list(extensions.items())
result.sort()

for resultList in result:
    print(resultList[0], resultList[1])
