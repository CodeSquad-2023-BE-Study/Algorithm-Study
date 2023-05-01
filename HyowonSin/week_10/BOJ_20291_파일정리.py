import sys

N = int(sys.stdin.readline())

answer = []
for _ in range(N):
    fileName = sys.stdin.readline().split(".")[1].strip()
    answer.append(fileName)

answer.sort()

index = 0
count = 1
while index < N-1:
    if answer[index] == answer[index+1]:
        count += 1
        index += 1
    else:
        print(answer[index], count)
        count = 1
        index += 1
print(answer[N-1], count)