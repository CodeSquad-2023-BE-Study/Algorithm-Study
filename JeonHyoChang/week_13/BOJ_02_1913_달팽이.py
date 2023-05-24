import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

table = []
for _ in range(n):
    table.append([0 for _ in range(n)])

flag = 0
x, y = n // 2, n // 2
table[x][y] = 1
if m == 1:
    resultX, resultY = n // 2 + 1, n // 2 + 1
else:
    resultX, resultY = 1, 1

flagList = []
for i in range(1, n):
    flagList.append(i)
    flagList.append(i)
flagList.append(n - 1)
# print(flagList)

flagCount = 0
for i in range(2, n ** 2 + 1):
    if flagList[0] == flagCount:
        flagCount = 0
        flag = (flag + 1) % 4
        flagList.pop(0)

    flagCount += 1
    if flag == 0:
        x -= 1
    elif flag == 1:
        y += 1
    elif flag == 2:
        x += 1
    else:
        y -= 1

    table[x][y] = i
    if i == m:
        resultX, resultY = x + 1, y + 1

for temp in table:
    print(' '.join(map(str, temp)))
print(resultX, resultY)
