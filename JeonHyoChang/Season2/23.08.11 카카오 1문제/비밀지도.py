def solution(n, arr1, arr2):
    answer = [[] * n for n in range(n)]

    map01 = [[] * n for n in range(n)]
    for i in range(n):
        maxBin = 2 ** (n - 1)
        temp = arr1[i]
        for _ in range(n):
            if temp >= maxBin:
                temp -= maxBin
                map01[i].append(1)
            else:
                map01[i].append(0)
            maxBin /= 2

    map02 = [[] * n for n in range(n)]
    for i in range(n):
        maxBin = 2 ** (n - 1)
        temp = arr1[i]
        for _ in range(n):
            if temp >= maxBin:
                temp -= maxBin
                map02[i].append(1)
            else:
                map02[i].append(0)
            maxBin /= 2

    return answer


print(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]))
1,2,4,8,16