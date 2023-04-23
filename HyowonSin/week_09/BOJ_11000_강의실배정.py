import sys

N = int(sys.stdin.readline())

I = []

for i in range(N):
    I.append(list(map(int, sys.stdin.readline().split())))

I.sort(key=lambda x: (x[1], x[0]))

room = [I[0][1]]

for i in I[1:]:
    for j in room:
        if i[0] >= j:
            room[room.index(j)] = i[1]
            break
    else:
        room.append(i[1])

print(len(room))
