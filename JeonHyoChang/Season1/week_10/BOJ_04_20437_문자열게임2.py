import sys

t = int(sys.stdin.readline())


def tokenCount(index, token):
    tempIndex = index

    count = 0
    for _ in range(k - 1):
        count += w[tempIndex + 1:].find(token) + 1
        tempIndex += w[tempIndex + 1:].find(token) + 1
    return count + 1


for _ in range(t):
    wordToken = {}
    w = sys.stdin.readline().split()[0]
    k = int(sys.stdin.readline())

    for temp in list(w):
        if wordToken.get(temp) is not None:
            wordToken[temp] += 1
        else:
            wordToken[temp] = 1

    # print(wordToken)
    result = [-1]
    for i in range(len(w)):
        if wordToken.get(w[i]) >= k:
            result.append(tokenCount(i, w[i]))
            wordToken[w[i]] -= 1

    result.sort()
    if len(result) == 1:
        print(-1)
    else:
        print(result[1], result[-1])
