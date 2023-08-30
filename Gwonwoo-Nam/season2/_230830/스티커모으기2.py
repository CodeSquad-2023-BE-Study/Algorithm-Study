def solution(sticker):
    answer = 0


    if len(sticker) == 1 :
        return sticker[0]
    # 첫번째 스티커를 뜯는 경우와 뜯지 않는 경우로 나눈다.

    # 뜯는 경우(마지막 인덱스를 뜯지 못한다.)
    dp = [0 for i in range(len(sticker))]
    dp[0] = sticker[0]
    dp[1] = sticker[0]
    for i in range(2, len(sticker) - 1) :
        dp[i] = max(dp[i-1], dp[i-2] + sticker[i])

    # 뜯지 않는 경우(마지막 인덱스를 뜯을 수 있다.)
    dp2 = [0 for i in range(len(sticker))]
    dp2[0] = 0
    dp2[1] = sticker[1]
    for i in range(2, len(sticker)) :
        dp2[i] = max(dp2[i-1], dp2[i-2] + sticker[i])

    for e in dp :
        answer = max(answer, e)
    for e in dp2 :
        answer = max(answer, e)


    return max(dp[len(sticker)-2], dp2[len(sticker)-1])
