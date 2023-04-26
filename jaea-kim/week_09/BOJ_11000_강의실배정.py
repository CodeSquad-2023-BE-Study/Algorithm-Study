"""
N : 수업 수
시작 시간 순으로 정렬 -> 다음 수업 시작 시간이 이전 수업 끝나는 시간보다 따르면 강의실 열기
heap ->
"""
import sys
import heapq

N = sys.stdin.readline()
lectures = [tuple(map(int, sys.stdin.readline().split())) for _ in range(int(N))]
lectures.sort()

# heapq 모듈로 변경
count = []
for i in lectures:
    if len(count) == 0:
        heapq.heappush(count, i[1])
    else:
        if count[0] <= i[0]:
            heapq.heappop(count)

        heapq.heappush(count, i[1])

print(len(count))
