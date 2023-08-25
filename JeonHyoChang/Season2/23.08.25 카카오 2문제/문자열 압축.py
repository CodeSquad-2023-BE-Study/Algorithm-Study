def combine(c, s):
    if c != 1:
        return str(c) + s
    return s


def solution(s):
    answer = s

    for i in range(1, len(s) // 2 + 1):
        tempStr = ""
        startStr = s[0:i]
        count = 1
        for j in range(i, len(s), i):
            if s[j:j + i] == startStr:
                count += 1
            else:
                tempStr += combine(count, startStr)
                startStr = s[j:j + i]
                count = 1
        tempStr += combine(count, startStr)
        print(tempStr)
        if len(answer) > len(tempStr) or i == 1:
            answer = tempStr

    return len(answer)


# print(solution("aabbaccc"))
# print(solution("ababcdcdababcdcd"))
# print(solution("abcabcdede"))
# print(solution("abcabcabcabcdededededede"))
# print(solution("xababcdcdababcdcd"))
# print(solution("a"))
