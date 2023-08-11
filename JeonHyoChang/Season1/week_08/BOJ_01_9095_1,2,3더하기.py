import sys

t = int(sys.stdin.readline())


def sumOf123(n):
    ways = [0] * (n + 1)
    ways[0] = 1

    for i in range(1, n + 1):
        ways[i] = ways[i - 1]
        if i - 2 >= 0:
            ways[i] += ways[i - 2]
        if i - 3 >= 0:
            ways[i] += ways[i - 3]

    return ways[n]


for _ in range(t):
    print(sumOf123(int(sys.stdin.readline())))
