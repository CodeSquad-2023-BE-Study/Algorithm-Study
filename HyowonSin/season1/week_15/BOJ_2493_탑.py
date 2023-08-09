import sys
from queue import PriorityQueue

N = int(sys.stdin.readline().strip())

tower = list(map(int, sys.stdin.readline().strip().split(' ')))
data = []
for i in range(N):
    data.append([tower[i], i+1])

stack = PriorityQueue()
result = [0] * len(data)

for i in range(len(data)-1, -1, -1):

    while stack.qsize() > 0:
        temp = stack.get()
        if temp[0] <= data[i][0]:
            result[temp[1]-1] = data[i][1]
        else:
            stack.put(temp)
            break

    stack.put(data[i])

for i in range(len(result)):
    print(result[i], end=' ')
