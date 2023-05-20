import sys

N = int(sys.stdin.readline().strip())
calendar = [0]*366
result = 0

for _ in range(N):
    start, end = map(int, sys.stdin.readline().strip().split(" "))
    for i in range(start, end+1):
        calendar[i] += 1

index = 1
width = 0
height = 0
while index < 366:
    if calendar[index] != 0:
        height = max(height, calendar[index])
        width += 1
    else:
        result += height * width
        height = 0
        width = 0
    index += 1

result += height * width
print(result)