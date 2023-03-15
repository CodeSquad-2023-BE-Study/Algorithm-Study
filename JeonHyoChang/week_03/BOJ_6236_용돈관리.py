import sys


def checkM(s):
    temp = s
    count = 1
    for i in moneyOfDay:
        if temp - i < 0:
            count += 1
            temp = s - i
        else:
            temp -= i

    return count


N, M = map(int, sys.stdin.readline().split())
moneyOfDay = list()
for _ in range(N):
    moneyOfDay.append(int(sys.stdin.readline()))

start = max(moneyOfDay)
end = sum(moneyOfDay)

while start <= end:
    mid = (start + end) // 2
    #print(start, mid, end, checkM(mid))
    if checkM(mid) > M:
        start = mid + 1
    else:
        end = mid - 1

print(start)
