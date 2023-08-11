import sys

n = int(sys.stdin.readline())
dList = list(map(int, sys.stdin.readline().split()))
dList.sort()

for i in range(len(dList) - 1):
    dList[len(dList) - 1] += dList[i] / 2

if dList[len(dList) - 1] % 1 > 0:
    print(dList[len(dList) - 1])
else:
    print(int(dList[len(dList) - 1]))
