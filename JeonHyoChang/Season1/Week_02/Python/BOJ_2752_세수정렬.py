import sys

numList = list(map(int, sys.stdin.readline().split()))
numList.sort()

print(*numList)