import sys

N, M = map(int, sys.stdin.readline().strip().split(' '))

dogam1 = []
dogam2 = {}

for i in range(N):
    pockemon = sys.stdin.readline().strip()
    dogam1.append(pockemon)
    dogam2[pockemon] = i

for i in range(M):
    input = sys.stdin.readline().strip()
    if input.isdigit():
        print(dogam1[int(input)-1])
    else:
        print(dogam2[input]+1)
