import sys


def findNum(listB, num):
    for i in range(len(listB)):
        if listB[i] >= num:
            listB[i] = num
            return i

    return 0


def LIS(listA, n):
    if n == 1:
        return 1

    listB = [0]
    for i in range(n):
        temp = findNum(listB, listA[i])
        if temp == 0:
            listB.append(listA[i])
        else:
            listB[temp] = listA[i]
        # print(listB)

    return len(listB) - 1


n = int(sys.stdin.readline())
listA = list(map(int, sys.stdin.readline().split()))
print(LIS(listA, n))
