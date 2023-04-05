import sys

k = int(sys.stdin.readline())
tree = list(map(int, sys.stdin.readline().split()))
level = [[] for _ in range(k)]


def bst(s, e, depth):
    if s == e:
        level[depth].append(tree[s])
        return
    root = (s + e) // 2
    level[depth].append(tree[root])
    bst(s, root - 1, depth + 1)
    bst(root + 1, e, depth + 1)


bst(0, len(tree) - 1, 0)

for i in level:
    for j in i:
        print(j, end=" ")
    print()
