import sys

n, d, k, c = map(int, sys.stdin.readline().split())
plateList = list()

for _ in range(n):
    plateList.append(int(sys.stdin.readline()))

plateList += plateList[:k - 1]
numOfSushiList = list()

for i in range(n):
    temp = set(plateList[i:i + k] + [c])
    numOfSushiList.append(len(temp))

print(max(numOfSushiList))
