from collections import deque

def solution(dartResult):
    answer = 0


    li = deque(dartResult)
    maps = [[0 for i in range(3)] for j in range(3)]

    i = 0

    # maps[0][0] = 0~10, maps[0][1] = S, D, T, maps[0][2] = *, #, null
    while li :
        if li :
            e = li.popleft();
        if e.isdigit() :
            if len(li) > 0 and li[0].isdigit() :
                maps[i][0] = (int(e)*10 + int(li.popleft()))
            else :
                maps[i][0] = int(e)

        if li :
            if li[0] in ("S", "D", "T") :
                maps[i][1] = li.popleft()
        if li :
            if li[0] in ("*", "#") :
                maps[i][2] = li.popleft()
        i+=1

    for i in range(3) :

        bonus = maps[i][1]
        option = maps[i][2]

        if bonus == "D" :
            maps[i][0] *= maps[i][0]
        elif bonus == "T" :
            maps[i][0] = maps[i][0]*maps[i][0]*maps[i][0]
        if option == "#" :
            maps[i][0] *= -1
        elif option == "*" :
            maps[i][0] *= 2
            if i>= 1 :
                maps[i-1][0] *= 2

    for i in range(3) :
        answer += maps[i][0]


    return answer
