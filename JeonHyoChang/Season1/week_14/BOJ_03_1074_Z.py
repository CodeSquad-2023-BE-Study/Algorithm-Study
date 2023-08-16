import sys

N, r, c = map(int, sys.stdin.readline().split())
result = 0


def divide(x, y, n):
    global result
    if n == 2:
        print(result + (r % 2) * 2 + (c % 2) * 1)
    else:
        halfN = n // 2
        if y <= r < y + halfN and x <= c < x + halfN:
            # print("#1")  # 좌상
            divide(x, y, halfN)
        elif y <= r < y + halfN and x + halfN <= c < x + n:
            # print("#2")  # 좌하
            result += halfN * halfN
            divide(x + halfN, y, halfN)
        elif y + halfN <= r < y + n and x <= c < x + halfN:
            # print("#3")  # 우상
            result += halfN * halfN * 2
            divide(x, y + halfN, halfN)
        else:
            # print("#4")  # 우하
            result += halfN * halfN * 3
            divide(x + halfN, y + halfN, halfN)


divide(0, 0, 2 ** N)
