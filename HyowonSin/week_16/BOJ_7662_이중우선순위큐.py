import sys
import heapq

T = int(sys.stdin.readline().strip())

for _ in range(T):
    k = int(sys.stdin.readline().strip())
    Q = []
    for i in range(k):
        Met, Val = sys.stdin.readline().strip().split(' ')
        if Met == 'I':
            heapq.heappush(Q, Val)
        elif Val == '1' and Q:
            del Q[-1]
        elif Val == '-1' and Q:
            heapq.heappop(Q)
    if Q:
        print(Q[-1], heapq.heappop(Q))
    else:
        print('EMPTY')
