from itertools import combinations


def solution(relation):
    row = len(relation)
    col = len(relation[0])
    relationCombinations = []

    for i in range(1, col + 1):
        relationCombinations.extend(combinations(range(col), i))

    # 유일성 체크
    uniqueKeys = []
    for x in relationCombinations:
        tempSet = set()
        for i in range(row):
            tempSet.add(tuple(relation[i][j] for j in x))
        if len(tempSet) == row:
            uniqueKeys.append(x)
    print(uniqueKeys)

    # 최소성 체크
    answer = set(uniqueKeys)
    print(answer)
    for i in range(len(uniqueKeys)):
        for j in range(i + 1, len(uniqueKeys)):
            if set(uniqueKeys[i]) & set(uniqueKeys[j]) == set(uniqueKeys[i]):
                answer.discard(uniqueKeys[j])

    return len(answer)


print(solution([["100", "ryan", "music", "2"], ["200", "apeach", "math", "2"], ["300", "tube", "computer", "3"],
                ["400", "con", "computer", "4"], ["500", "muzi", "music", "3"], ["600", "apeach", "music", "2"]]))
