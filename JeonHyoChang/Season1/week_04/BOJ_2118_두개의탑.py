import sys

n = int(sys.stdin.readline())
pointList = list()

for _ in range(n):
    pointList.append(int(sys.stdin.readline()))
maxLength = sum(pointList)

left = 0
right = 1
sumA = pointList[left]
resultList = list()

while left < n:
    if sumA >= maxLength - sumA:
        temp = [sumA, maxLength - sumA]
        resultList.append(min(temp))
        sumA -= pointList[left]
        left += 1
    else:
        sumA += pointList[right]
        right = (right + 1) % n

print(max(resultList))
