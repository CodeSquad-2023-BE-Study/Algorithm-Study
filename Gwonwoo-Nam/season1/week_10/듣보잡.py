# Two Pointer를 활용한 문제
n,m = map(int, input().split())

strsA = []
for i in range(n):
  strsA.append(input())

strsA.sort()

strsB = []
for i in range(m):
  strsB.append(input())

strsB.sort()

answer = []
i, j = 0, 0
while(i != len(strsA) and j != len(strsB)):
  if (strsA[i] == strsB[j]):
    answer.append(strsA[i])
    i += 1
    j += 1
  else :
    if (strsA[i] < strsB[j]) :
      i += 1
    else :
      j += 1

print(len(answer))
for i in answer:
  print(i)