import sys

N, r, c = map(int, sys.stdin.readline().strip().split(" "))
count = 0


def find_num(N, r, c):
    global count
    M = 2**(N-1)

    if M == 1:
        count += (1+c+r*2)
        print(count-1)
        return

    if r < M:
        if c < M:
            find_num(N-1, r, c)
        else:
            count += M**2
            find_num(N-1, r, c-M)
    else:
        if c < M:
            count += M**2 * 2
            find_num(N-1, r-M, c)
        else:
            count += M**2 * 3
            find_num(N-1, r-M, c-M)


find_num(N, r, c)
