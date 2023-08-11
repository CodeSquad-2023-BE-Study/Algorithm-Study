import sys

N, M = map(int, sys.stdin.readline().split())

dicName = {}
dicNum = {}
for i in range(N):
    pokName = sys.stdin.readline().rsplit()[0]
    dicName[pokName] = i + 1
    dicNum[i + 1] = pokName

for _ in range(M):
    problem = sys.stdin.readline().rsplit()[0]

    if problem.isnumeric():
        print(dicNum[int(problem)])
    else:
        print(dicName[problem])
