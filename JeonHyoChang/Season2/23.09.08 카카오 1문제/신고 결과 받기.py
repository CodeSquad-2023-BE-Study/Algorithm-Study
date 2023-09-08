def solution(id_list, report, k):
    answer = []

    reportDic = {}
    reportCountDic = {}
    for x in id_list:
        reportDic[x] = set()
        reportCountDic[x] = 0

    for y in report:
        user = y.split(" ")
        reportDic[user[0]].add(user[1])

    for z in id_list:
        temp = reportDic[z]
        for i in temp:
            reportCountDic[i] += 1

    banSet = set()
    for z in id_list:
        if reportCountDic[z] >= k:
            banSet.add(z)

    for z in id_list:
        answer.append(len(reportDic[z] & banSet))

    return answer


print(
    solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"],
             2))
print(solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3))
