import sys

n = int(sys.stdin.readline())

tree = {}
for _ in range(n):
    n1, n2, n3 = map(str, sys.stdin.readline().split())
    tree[n1] = [n2, n3]


def preorderTraversal(nood):
    if nood != '.':
        print(nood, end="")
        preorderTraversal(tree.get(nood)[0])
        preorderTraversal(tree.get(nood)[1])


def inorderTraversal(nood):
    if nood != '.':
        inorderTraversal(tree.get(nood)[0])
        print(nood, end="")
        inorderTraversal(tree.get(nood)[1])


def postorderTraversal(nood):
    if nood != '.':
        postorderTraversal(tree.get(nood)[0])
        postorderTraversal(tree.get(nood)[1])
        print(nood, end="")


preorderTraversal('A')
print()

inorderTraversal('A')
print()

postorderTraversal('A')
