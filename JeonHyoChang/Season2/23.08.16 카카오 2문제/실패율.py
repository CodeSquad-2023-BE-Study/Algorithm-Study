def solution(N, stages):
    dic = {}
    for i in range(1, N + 1):
        dic[i] = stages.count(i)

    users = len(stages)
    answerTemp = []
    for i in range(1, N + 1):
        if users != 0:
            answerTemp.append((dic[i] / users, i))
        else:
            answerTemp.append((0, i))
        users -= dic[i]
    print(answerTemp)

    answerTemp02 = sorted(answerTemp, key=lambda x: (-x[0], x[1]))
    answer = [x[1] for x in answerTemp02]
    return answer


print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
print(solution(4, [4, 4, 4, 4, 4]))
print(solution(2, [1, 1, 1, 1]))
