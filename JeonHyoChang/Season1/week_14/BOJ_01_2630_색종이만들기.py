import sys

n = int(sys.stdin.readline())

array = []
for _ in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    array.append(row)

# for temp in array:
#     print(temp)
zerosCount = 0
onesCount = 0


def divide(x, y, w, z):
    global zerosCount
    global onesCount
    divFlag = 0
    cutFlag = 0
    for i in range(w, z):
        if not (all(num == 0 for num in array[i][x:y])):
            cutFlag = 1
            break
    if cutFlag == 0:
        zerosCount += 1
        divFlag = 1

    cutFlag = 0
    for i in range(w, z):
        if not (all(num == 1 for num in array[i][x:y])):
            cutFlag = 1
            break
    if cutFlag == 0:
        onesCount += 1
        divFlag = 1

    if divFlag == 0 and z - w > 0:
        divide(x, (x+y) // 2, w, (w+z) // 2)
        divide((x+y) // 2, y, w, (w+z) // 2)
        divide(x, (x+y) // 2, (w+z) // 2, z)
        divide((x+y) // 2, y, (w+z) // 2, z)


divide(0, n, 0, n)
print(zerosCount)
print(onesCount)
