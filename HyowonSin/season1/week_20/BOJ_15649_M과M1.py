import sys

N, M = map(int, sys.stdin.readline().strip().split(' '))

answer = []


def dfs():
    if len(answer) == M:
        print(' '.join(map(str, answer)))
        return

    for i in range(1, N + 1):
        if i not in answer:
            answer.append(i)
            dfs()
            answer.pop()


dfs()
