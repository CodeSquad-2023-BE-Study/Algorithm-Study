import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()
x = int(sys.stdin.readline())

left = 0
right = n - 1
count = 0

while left < right:
    sumOfNum = arr[left] + arr[right]
    if sumOfNum > x:
        right -= 1
    elif sumOfNum < x:
        left += 1
    else:
        left += 1
        right -= 1
        count += 1

print(count)
