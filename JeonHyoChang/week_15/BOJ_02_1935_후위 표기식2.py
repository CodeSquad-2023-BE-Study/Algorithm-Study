import sys
from collections import deque

N = int(sys.stdin.readline())
postfix = list(map(str, sys.stdin.readline().split()[0]))
deqPost = deque(postfix)

dic = {}
alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
for i in range(N):
    dic[alphabet[i]] = int(sys.stdin.readline())

# print(deqPost)
# print(dic)

resultStack = []
while len(deqPost) > 0:
    temp = deqPost.popleft()

    if dic.get(temp) is None:
        tempNum01 = resultStack.pop()
        tempNum02 = resultStack.pop()
        resultTemp = 0

        if temp == "*":
            resultTemp = tempNum02 * tempNum01
        elif temp == "/":
            resultTemp = tempNum02 / tempNum01
        elif temp == "+":
            resultTemp = tempNum02 + tempNum01
        else:
            resultTemp = tempNum02 - tempNum01
        resultStack.append(resultTemp)

    else:
        resultStack.append(dic[temp])

formatted_number = "{:.2f}".format(resultStack[0])
print(formatted_number)
