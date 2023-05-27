import sys

N = int(input())
tree = [list(map(int, input().split(' '))) for _ in range(N)]
# if N == 1:
#     print(0)
#     sys.exit()

tree.sort(key=lambda x: x[0])


def round(tree, start, direction):
    global count
    count += 1
    print(count)
    if tree[start][direction] == -1:
        return

    if tree[start][0] == tree[-1][0]:
        return

    preIndex = start
    for i in range(len(tree)):
        if tree[start][direction] == tree[i][0]:  # direction 노드 찾기
            preIndex = start
            start = i
            break

    round(tree, start, 1)
    round(tree, preIndex, 2)


count = 0
round(tree, 0, 1)
print(count)
