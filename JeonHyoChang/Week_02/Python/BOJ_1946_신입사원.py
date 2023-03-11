import sys

T = int(sys.stdin.readline())
result = list()

for _ in range(T):
    grade_list = list()
    N = int(sys.stdin.readline())
    for _ in range(N):
        fg, sg = map(int, sys.stdin.readline().split())
        grade_list.append((fg, sg))

    grade_list.sort(key=lambda o: o[0])

    # 합격자 수 & 기준이 되는 2차 성적
    passer_count = 1
    standard = grade_list[0][1]

    # 기준보다 등수가 높을시 합격자에 추가하며, 기준을 그사람으로 변경
    for i in range(1, N):
        if standard > grade_list[i][1]:
            passer_count += 1
            standard = grade_list[i][1]

    result.append(passer_count)

for temp in result:
    print(temp)
