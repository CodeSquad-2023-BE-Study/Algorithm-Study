import sys
import heapq

T = int(sys.stdin.readline())

for _ in range(T):
    minHeap = []
    maxHeap = []
    visited = [False] * 1_000_001

    k = int(sys.stdin.readline())

    for i in range(k):
        command, num = sys.stdin.readline().split()

        if command == 'I':
            heapq.heappush(minHeap, (int(num), i))
            heapq.heappush(maxHeap, (-int(num), i))
            visited[i] = True
        elif num == '1':
            while maxHeap and not visited[maxHeap[0][1]]:
                heapq.heappop(maxHeap)
            if maxHeap:
                visited[maxHeap[0][1]] = False
                heapq.heappop(maxHeap)
        elif num == '-1':
            while minHeap and not visited[minHeap[0][1]]:
                heapq.heappop(minHeap)
            if minHeap:
                visited[minHeap[0][1]] = False
                heapq.heappop(minHeap)

    while minHeap and not visited[minHeap[0][1]]:
        heapq.heappop(minHeap)
    while maxHeap and not visited[maxHeap[0][1]]:
        heapq.heappop(maxHeap)

    if minHeap and maxHeap:
        max_value = -maxHeap[0][0]
        min_value = minHeap[0][0]
        print(max_value, min_value)
    else:
        print("EMPTY")
