import sys
sys.setrecursionlimit(10**n)

def oneSecondCheck(n):
    # return [n - 1, n + 1, (n - 1) * 2, n * 2 - 1, n * 2 + 1, (n + 1) * 2]
    return [(n + 1) * 2, n * 2 + 1, n * 2 - 1, (n - 1) * 2, n + 1, n - 1]


def dfs(n, time):
    global K
    global halfK
    global flag
    oneSecondList = oneSecondCheck(n)
    if K in oneSecondList:
        timeList.append(time)
        flag = 1
    for location in oneSecondList:
        if location <= halfK and flag == 0:
            dfs(location, time + 1)


N, K = map(int, sys.stdin.readline().split())

# 4, 6, 8, 9, 11, 12

if N >= K:
    print(N - K)
if N * 2 == K:
    print(0)
else:
    halfK = K // 2
    if K % 2 == 1:
        halfK = (K + 1) // 2
    flag = 0
    timeList = []
    dfs(N, 1)
    print(timeList[0])
