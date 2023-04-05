import sys

sys.setrecursionlimit(10 ** 7)

n, q = map(int, sys.stdin.readline().split())

groundTree = {}
for i in range(1, n + 1):
    groundTree[i] = False


def roadToList(num):
    temp = []
    while num > 0:
        temp.append(num)
        num //= 2
    return temp


for _ in range(q):
    x = int(sys.stdin.readline())
    rList = roadToList(x)

    rootCheck = True
    while len(rList) > 0:
        tempNum = rList.pop(-1)
        if groundTree[tempNum]:
            print(tempNum)
            rootCheck = False
            break

    if rootCheck:
        groundTree[x] = True
        print(0)
