import sys
import heapq

N = int(sys.stdin.readline())

result = []
for _ in range(N):
    temp = list(map(int, sys.stdin.readline().split()))
    for x in temp:
        if len(result) == 0:
            heapq.heappush(result, x)
        elif result[0] < x:
            heapq.heappush(result, x)

    for _ in range(N, len(result)):
        heapq.heappop(result)

print(result[0])
