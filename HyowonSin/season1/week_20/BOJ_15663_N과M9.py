import sys

N, M = map(int, sys.stdin.readline().strip().split(' '))
arr = list(map(int, sys.stdin.readline().strip().split(' ')))

p = []
answer = []
index = []


def dfs(num_list, index):
    if len(p) == M:
        answer.append(' '.join(map(str, p)))
        return

    for i in range(len(num_list)):
        if i not in index:
            p.append(num_list[i])
            index.append(i)
            dfs(num_list, index)
            p.pop()
            index.pop()


dfs(sorted(arr), index)
for i in sorted(set(answer), key=lambda x: list(map(int, x.split()))):
    print(i)
