import sys

T = int(sys.stdin.readline())

for _ in range(T):
    W = sys.stdin.readline().strip()
    K = int(sys.stdin.readline())

    temp = set(W)
    setW = set()

    for i in temp:
        if W.count(i) >= K:
            setW.add(i)

    if len(setW) < 1:
        print(-1)
        continue

    index = []
    min = 10001
    max = -1

    for i in setW:
        index = list(filter(lambda x: W[x] == i, range(len(W))))
        for j in range(len(index)-K+1):
            value = int(index[j+K-1] - index[j])
            if min > value:
                min = value
            if max < value:
                max = value
    print(min+1, max+1)
