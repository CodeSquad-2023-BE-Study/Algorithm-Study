import sys

N, M = map(int, sys.stdin.readline().split())
treeHeight = list(map(int, sys.stdin.readline().split()))


def checkSumTree(target):
    treeSum = 0
    for i in treeHeight:
        if i - target >= 0:
            treeSum += i - target

    return treeSum


start, end = 1, max(treeHeight)

while start <= end:
    mid = (start + end) // 2
    #print("1: ", start, mid, end, checkSumTree(mid))
    if checkSumTree(mid) >= M:
        start = mid + 1
    else:
        end = mid - 1
    #print("2: ", start, mid, end, checkSumTree(mid), "\n")

print(end)
