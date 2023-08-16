import sys

s, e, q = map(str, sys.stdin.readline().split())
S = int(s.split(':')[0]) * 60 + int(s.split(':')[1])
E = int(e.split(':')[0]) * 60 + int(e.split(':')[1])
Q = int(q.split(':')[0]) * 60 + int(q.split(':')[1])

start = []
end = []
while True:
    temp = sys.stdin.readline().split()
    if not temp:
        break

    tempTime = int(temp[0].split(':')[0]) * 60 + int(temp[0].split(':')[1])
    if tempTime <= S:
        start.append(temp[1])
    elif Q >= tempTime >= E:
        end.append(temp[1])

print(len(set(start) & set(end)))
