import sys

sys.setrecursionlimit(10 ** 6)

treeList = []
tree = {}
for _ in range(10000):
    try:
        n = int(sys.stdin.readline())
        treeList.append(n)
    except:
        break
start = treeList[0]


def getBigger(root, tList):
    for i in range(len(tList)):
        if tList[i] > root:
            return i
    return -1


def splitTree(tList):
    if len(tList) > 0:
        root = tList.pop(0)
        temp = getBigger(root, tList)
        if temp == 0:
            tree[root] = [-1, tList[0]]
            splitTree(tList)
        elif temp == -1:
            if len(tList) == 0:
                tree[root] = [-1, -1]
            else:
                tree[root] = [tList[0], -1]
                splitTree(tList)
        else:
            list01 = tList[:temp]
            list02 = tList[temp:]
            tree[root] = [list01[0], list02[0]]
            splitTree(list01)
            splitTree(list02)


def postorderTraversal(nood):
    if nood != -1:
        postorderTraversal(tree.get(nood)[0])
        postorderTraversal(tree.get(nood)[1])
        print(nood)


splitTree(treeList)
postorderTraversal(start)
