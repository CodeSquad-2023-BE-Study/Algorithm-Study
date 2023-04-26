import sys

N = sys.stdin.readline()
P = sorted(map(int, sys.stdin.readline().split()))
answer = 0
for i in range(len(P)):
    answer += int(P[i]) * (len(P) - i)

print(answer)
