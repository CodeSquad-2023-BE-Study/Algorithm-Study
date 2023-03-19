import sys

n, m = map(int, sys.stdin.readline().split())

arrA = list(map(int, sys.stdin.readline().split()))
arrB = list(map(int, sys.stdin.readline().split()))
arrResult = (arrA + arrB)
arrResult.sort()

for num in arrResult:
    print(num, end=" ")
