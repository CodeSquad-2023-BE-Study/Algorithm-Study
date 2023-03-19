import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
nArr = list(map(int, sys.stdin.readline().split()))
nArr.sort()

count = 0
i = 0
j = n - 1

while i < j:
    sumArr = nArr[i] + nArr[j]
    if sumArr > m:
        j -= 1
    elif sumArr < m:
        i += 1
    else:
        i += 1
        j -= 1
        count += 1

print(count)
