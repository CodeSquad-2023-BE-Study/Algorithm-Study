import sys
sys.setrecursionlimit(10**6)

count = 0
result = []


def pseudoInorder(nood):
    global count
    global result
    if tree[nood][0] != -1:
        tempLeft = tree[nood][0]
        tree[nood] = [-1, tree[nood][1]]

        count += 1
        pseudoInorder(tempLeft)
        count += 1

    if tree[nood][1] != -1:
        tempRight = tree[nood][1]
        tree[nood] = [-1, -1]

        count += 1
        pseudoInorder(tempRight)
        count += 1
    if len(set(tuple(item) for item in tree.values())) == 1:
        result.append(count)


n = int(sys.stdin.readline())

tree = {}
for _ in range(n):
    root, left, right = map(int, sys.stdin.readline().split())
    tree[root] = [left, right]

# print(tree)

pseudoInorder(1)
print(min(result))
