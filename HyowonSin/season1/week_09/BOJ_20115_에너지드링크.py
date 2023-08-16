import sys

N = sys.stdin.readline()
X = sorted(map(int, sys.stdin.readline().split()))

while len(X) != 1:
    a = X.pop(0)
    b = X.pop(-1)
    X.append((a/2)+b)

if X[0] % 1 == 0:
    print(int(X[0]))
else:
    print(X[0])
