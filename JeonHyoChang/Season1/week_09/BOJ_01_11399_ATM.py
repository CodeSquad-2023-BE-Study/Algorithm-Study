import sys

n = int(sys.stdin.readline())
pList = list(map(int, sys.stdin.readline().split()))
pList.sort()

for i in range(1, len(pList)):
    pList[i] += pList[i - 1]

print(sum(pList))
