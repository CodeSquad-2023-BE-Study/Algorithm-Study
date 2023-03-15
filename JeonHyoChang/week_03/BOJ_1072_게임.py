import sys

X, Y = map(int, sys.stdin.readline().split())
Z = (Y * 100) // X

start = 1
end = X
answer = 0

if Z >= 99:
    answer = -1
else:
    while start <= end:
        mid = (start + end) // 2
        if Z >= (Y + mid) * 100 // (X + mid):
            start = mid + 1
        else:
            end = mid - 1
            answer = mid

print(answer)
