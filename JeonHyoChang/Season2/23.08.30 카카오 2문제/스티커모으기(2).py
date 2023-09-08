def solution(sticker):
    answer01 = []
    answer02 = []

    answer01.append(0)
    answer02.append(sticker[0])

    if len(sticker) > 1:
        answer01.append(sticker[1])
        answer02.append(sticker[0])

    for i in range(2, len(sticker)):
        answer01.append(max(answer01[i - 1], answer01[i - 2] + sticker[i]))
        answer02.append(max(answer02[i - 1], answer02[i - 2] + sticker[i]))

    if len(sticker) == 1:
        return sticker[0]
    return max(answer01[len(sticker) - 1], answer02[len(sticker) - 2])


print(solution([14, 6, 5, 11, 3, 9, 2, 10]))
