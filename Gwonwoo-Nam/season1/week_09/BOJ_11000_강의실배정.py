import sys
from queue import PriorityQueue

n = int(input())
pq = PriorityQueue()

arr = []
for i in range(n):
  a, b = map(int, sys.stdin.readline().split())
  arr.append([a, b])

arr.sort(key=lambda x: (x[0]))

# 초기 종료 시간
pq.put(arr[0][1])

for i in range(1, len(arr)):
  val = pq.get()
  if arr[i][0] < val:
    pq.put(arr[i][1])
    pq.put(val)
  else:
    pq.put(arr[i][1])


print(pq.qsize())