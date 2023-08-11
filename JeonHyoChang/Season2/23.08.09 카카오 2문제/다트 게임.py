def solution(dartResult):
    result = []
    tempScore = -1
    for x in list(dartResult):
        if x in ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10']:
            if tempScore == 1 and x == '0':
                tempScore = 10
            else:
                tempScore = int(x)
        elif x in ['S', 'D', 'T']:
            if x == 'D':
                tempScore **= 2
            elif x == 'T':
                tempScore **= 3
            result.append(tempScore)
            tempScore = -1
        else:
            if x == '#':
                result[len(result) - 1] *= -1
            else:
                if len(result) == 1:
                    result[0] *= 2
                else:
                    result[len(result) - 1] *= 2
                    result[len(result) - 2] *= 2
    return sum(result)


print(solution('1S2D*3T'))
print(solution('1D2S#10S'))
