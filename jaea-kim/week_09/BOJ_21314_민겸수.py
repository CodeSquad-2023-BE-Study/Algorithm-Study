"""
가장 큰 값이 되려면 K앞에 최대한 많은 M이 오도록
최소가 되려면 K와 M을 나누기
-> K가 나올 때까지 M의 갯수 카운트 하여 연산
"""

number = list(input())

count = 0
maxList = []
minList = []

for n in number:
    if n == 'M':
        count += 1
    else:
        if count > 0:
            maxList.append(str((10 ** count) * 5))
            minList.append(str(10 ** (count - 1)))
            minList.append(str(5))
        else:
            maxList.append(str(5))
            minList.append(str(5))
        count = 0
if count > 0 :
    maxList.extend([str(1)] * count)
    minList.append(str(10 ** (count - 1)))

print("".join(maxList))
print("".join(minList))