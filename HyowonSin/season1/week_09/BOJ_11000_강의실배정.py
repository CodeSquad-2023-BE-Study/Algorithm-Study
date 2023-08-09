import sys
from queue import PriorityQueue

N = int(sys.stdin.readline())

I = []

for i in range(N):
    I.append(list(map(int, sys.stdin.readline().split())))

I.sort(key=lambda x: (x[0], x[1]))

room = PriorityQueue()
room.put(I[0][1])

for i in I[1:]:
    if room.queue[0] <= i[0]:
        room.get()
        room.put(i[1])
    else:
        room.put(i[1])

print(room.qsize())