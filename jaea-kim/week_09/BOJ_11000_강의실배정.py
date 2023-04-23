"""
N : 수업 수
시작 시간 순으로 정렬 -> 다음 수업 시작 시간이 이전 수업 끝나는 시간보다 따르면 강의실 열기

"""
import sys

N = sys.stdin.readline()
lectures = [tuple(map(int, sys.stdin.readline().split())) for _ in range(int(N))]
lectures.sort()

count = []
for i in lectures:
    if len(count) == 0:
        count.append(i[1])
    else:
        flag = False
        for j in count:
            if i[0] >= j:
                j = i[1]
                flag = True
        if not flag:
            count.append(i[1])

print(len(count))
