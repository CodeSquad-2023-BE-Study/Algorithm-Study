def solution(record):
    answer = []

    userDic = {}
    recordChet = []
    for x in record:
        temp = x.split(" ")
        if temp[0] == "Enter" or temp[0] == "Leave":
            recordChet.append((temp[0], temp[1]))
        if temp[0] != "Leave":
            userDic[temp[1]] = temp[2]

    for y in recordChet:
        tempStr = userDic[y[1]] + "님이 "
        if y[0] == "Enter":
            answer.append(tempStr + "들어왔습니다.")
        else:
            answer.append(tempStr + "나갔습니다.")

    return answer


print(solution(
    ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]))

