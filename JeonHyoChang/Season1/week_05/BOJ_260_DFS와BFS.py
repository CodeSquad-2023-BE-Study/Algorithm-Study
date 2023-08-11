import sys

n, m, v = map(int, sys.stdin.readline().split())
linkMap = {}

for i in range(n):
    linkMap[i + 1] = []

for _ in range(m):
    num01, num02 = map(int, sys.stdin.readline().split())
    linkMap[num01] = sorted(linkMap[num01] + [num02])
    linkMap[num02] = sorted(linkMap[num02] + [num01])


def dfs_def(start, dfs=[]):
    dfs.append(start)

    print(start, end=" ")
    for node in linkMap[start]:
        if node not in dfs:
            dfs_def(node, dfs)
    return dfs


def bfs_def(start, bfs=[]):
    q = [start]

    while q:
        temp = q.pop(0)
        bfs.append(temp)
        print(temp, end=" ")
        for node in linkMap[temp]:
            if (node not in bfs) and (node not in q):
                q.append(node)


dfs_def(v)
print()
bfs_def(v)
