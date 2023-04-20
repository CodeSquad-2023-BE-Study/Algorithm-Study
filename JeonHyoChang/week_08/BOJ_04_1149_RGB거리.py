import sys

n = int(sys.stdin.readline())

rgbList = []
for _ in range(n):
    rgbList.append(list(map(int, sys.stdin.readline().split())))

for i in range(1, len(rgbList)):
    rgbList[i][0] += min(rgbList[i - 1][1], rgbList[i - 1][2])
    rgbList[i][1] += min(rgbList[i - 1][0], rgbList[i - 1][2])
    rgbList[i][2] += min(rgbList[i - 1][0], rgbList[i - 1][1])

print(min(rgbList[n - 1]))
