import sys
import heapq

N = int(sys.stdin.readline().strip())

Q = []

for _ in range(N):
    arr = list(map(int, sys.stdin.readline().strip().split(' ')))
    for i in arr:
        heapq.heappush(Q, i)
        if len(Q) > N:
            heapq.heappop(Q)

print(heapq.heappop(Q))
