def solution(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()

    setStr1 = []
    setStr2 = []

    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            setStr1.append(str1[i:i+2])

    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            setStr2.append(str2[i:i+2])

    setStr1.sort()
    setStr2.sort()

    intersection = 0
    union = 0

    p1 = 0
    p2 = 0

    while 1:
        if p1 == len(setStr1) and p2 == len(setStr2):
            break
        if p1 == len(setStr1):
            p2 += 1
            union += 1
            break
        elif p2 == len(setStr2):
            p1 += 1
            union += 1
            break
        if setStr1[p1] < setStr2[p2]:
            p1 += 1
            union += 1
            continue
        elif setStr1[p1] > setStr2[p2]:
            p2 += 1
            union += 1
            continue
        count1 = 1
        count2 = 1
        while p1 < len(setStr1)-1 and setStr1[p1] == setStr1[p1+1]:
            count1 += 1
            p1 += 1
        while p2 < len(setStr2)-1 and setStr2[p2] == setStr2[p2+1]:
            count2 += 1
            p2 += 1
        intersection += min(count1, count2)
        union += max(count1, count2)
        p1 += 1
        p2 += 1

    if union == 0:
        return 65536
    return int(intersection / union * 65536)

print(solution('FRANCE', 'french'))