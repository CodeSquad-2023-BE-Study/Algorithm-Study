import sys

N = int(sys.stdin.readline())
listN = list(map(int, sys.stdin.readline().split()))
# listN = [int(i) for i in sys.stdin.readline().split()]
listN.sort()

M = int(sys.stdin.readline())
listM = list(map(int, sys.stdin.readline().split()))


def findNum(num):
    start = 0
    end = N - 1

    while start <= end:
        mid = (start + end) // 2
        if listN[mid] < num:
            start = mid + 1
        else:
            end = mid - 1

    if listN[start] == num:
        print(1)
    else:
        print(0)


for num in listM:
    if num > listN[-1] or num < listN[0]:
        print(0)
    else:
        findNum(num)
