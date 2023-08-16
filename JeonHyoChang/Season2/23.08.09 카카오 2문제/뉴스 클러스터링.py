def solution(str1, str2):
    str1, str2 = str.upper(str1), str.upper(str2)
    listStr1, listStr2 = [], []

    for i in range(len(str1) - 1):
        if str1[i].isalpha() and str1[i + 1].isalpha():
            listStr1.append(str1[i:i + 2])
    for i in range(len(str2) - 1):
        if str2[i].isalpha() and str2[i + 1].isalpha():
            listStr2.append(str2[i:i + 2])

    if len(listStr1) + len(listStr2) == 0:
        return 65536

    count = 0
    for x in listStr1:
        if x in listStr2:
            listStr2.remove(x)
            count += 1

    return int(count / (len(listStr1) + len(listStr2)) * 65536)


print(solution('FRANCE', 'french'))
print(solution('handshake', 'shake hands'))
print(solution('aa1+aa2', 'AAAA12'))
print(solution('E=M*C^2', 'e=m*c^2'))
