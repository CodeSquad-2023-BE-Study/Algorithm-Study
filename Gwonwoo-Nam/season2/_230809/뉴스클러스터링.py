from collections import defaultdict
import math


def solution(str1, str2):
    a = defaultdict(int)
    b = defaultdict(int)
    for i in range(len(str1) - 1):
        st = str1[i:(i + 2)]
        if st.isalpha():
            a[st.lower()] += 1
    for i in range(len(str2) - 1):
        st = str2[i:(i + 2)]
        if st.isalpha():
            b[st.lower()] += 1

    if len(b) == 0 and len(a) == 0:
        return 65536

    com = []
    uni = []
    # 합집합
    # 교집합
    for e in a.keys():
        if e in b.keys():
            # 교집합인 경우
            for i in range(min(a[e], b[e])) :
                com.append(e)
            for i in range(max(a[e], b[e])) :
                uni.append(e)
        else:
            # A에만 소속
            for i in range(a[e]):
                uni.append(e)
    for e in b:
        if e not in a:
            # B에만 소속
            for i in range(b[e]):
                uni.append(e)
    print(uni, com)

    answer = 65536 * len(com) / len(uni)
    return math.floor(answer)


solution(	"aa1+aa2", "AAAA12")
