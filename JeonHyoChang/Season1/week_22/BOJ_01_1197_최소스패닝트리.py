import sys


def findParent(parent, x):
    if parent[x] != x:
        parent[x] = findParent(parent, parent[x])
    return parent[x]


def unionParent(parent, A, B):
    A = findParent(parent, A)
    B = findParent(parent, B)
    if A < B:
        parent[B] = A
    else:
        parent[A] = B


def spanningCheck(tree, V):
    tree.sort(key=lambda x: x[2])
    parent = [i for i in range(V + 1)]
    costSum = 0

    for A, B, C in tree:
        if findParent(parent, A) != findParent(parent, B):
            unionParent(parent, A, B)
            costSum += C

    return costSum


v, e = map(int, sys.stdin.readline().split())

spanningTree = []
for _ in range(e):
    a, b, c = map(int, sys.stdin.readline().split())
    spanningTree.append([a, b, c])

print(spanningCheck(spanningTree, v))
