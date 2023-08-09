import sys


def findParent(parent, x):
    if parent[x] != x:
        parent[x] = findParent(parent, parent[x])
    return parent[x]


def unionParent(parent, A, B):
    A = findParent(parent, A)
    B = findParent(parent, B)
    if A < B:
        parent[B] = A
    else:
        parent[A] = B


n, m = map(int, sys.stdin.readline().split())

sT = []
totalCost = 0
for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    sT.append([a, b, c])
    totalCost += c

sT.sort(key=lambda x: x[2])
parent = [i for i in range(n + 1)]
costSum = 0
for A, B, C in sT:
    if findParent(parent, A) != findParent(parent, B):
        unionParent(parent, A, B)
        costSum += C

tempSet = set(parent[1:])
tempSet.remove(1)
flag = 0
for x in tempSet:
    if parent[x] != 1:
        flag = 1
        break

if flag == 1:
    print(-1)
else:
    print(totalCost - costSum)
