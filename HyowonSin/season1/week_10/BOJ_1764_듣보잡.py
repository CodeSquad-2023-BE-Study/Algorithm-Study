import sys

N, M = map(int, sys.stdin.readline().split())

unheard = []
unseen = []
answer = []

for _ in range(N):
    unheard.append(sys.stdin.readline())

for _ in range(M):
    unseen.append(sys.stdin.readline())

unheard.sort()
unseen.sort()

index = 0
for people in unheard:
    for i in range(index, M):
        if people == unseen[i]:
            answer.append(unseen[i])
            index = i+1
            break
        elif people < unseen[index]:
            break
        else:
            index += 1

print(len(answer))
for i in answer:
    print(i, end="")
