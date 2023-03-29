import sys

computerNum = int(sys.stdin.readline())
linkNum = int(sys.stdin.readline())
linkMap = {}

for i in range(computerNum):
    linkMap[i + 1] = []

for _ in range(linkNum):
    com01, com02 = map(int, sys.stdin.readline().split())
    linkMap[com01] = linkMap[com01] + [com02]
    linkMap[com02] = linkMap[com02] + [com01]

linkStack = linkMap[1]
i = 0
while i < len(linkStack):
    linkStack = linkStack + list(set(linkMap[linkStack[i]]) - set(linkStack))
    i += 1

if linkStack.count(1) > 0:
    linkStack.remove(1)
print(len(set(linkStack)))
