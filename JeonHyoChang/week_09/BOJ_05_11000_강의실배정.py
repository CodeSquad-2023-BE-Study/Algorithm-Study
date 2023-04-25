import sys
from queue import PriorityQueue

sys.setrecursionlimit(10 ** 9)

n = int(sys.stdin.readline())

roomList = []
for _ in range(n):
    roomList.append(list(map(int, sys.stdin.readline().split())))
roomList.sort()

que = PriorityQueue()
que.put(roomList[0][1])

for i in range(1, len(roomList)):
    temp = que.get()

    if temp <= roomList[i][0]:
        que.put(roomList[i][1])
    else:
        que.put(temp)
        que.put(roomList[i][1])

print(que.qsize())
