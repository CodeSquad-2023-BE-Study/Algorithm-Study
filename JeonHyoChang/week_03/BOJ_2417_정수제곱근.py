import sys

n = int(sys.stdin.readline())

start = 0
end = n

while start <= end:
    mid = (start + end) // 2
    if mid ** 2 < n:
        start = mid + 1
    else:
        end = mid - 1

print(start)
