import sys

N = sys.stdin.readline()

I = []

for i in range(int(N)):
    t = sys.stdin.readline().split()
    if int(t[0]) <= int(t[1]):
        I.append(t)

I.sort(key=lambda x: (int(x[1]), int(x[0])))

count = 1
pointer = 0
while pointer < len(I):
    end = int(I[pointer][1])
    for i in range(pointer+1, len(I)):
        if int(I[i][0]) >= end:
            count += 1
            pointer = i
            break
        if i == len(I)-1:
            pointer = i+1
    if pointer == len(I)-1:
        break

print(count)
