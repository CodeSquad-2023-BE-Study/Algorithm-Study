"""
N 개의 회의
시작시간 - 종료시간
회의를 최대한 많이 하기 위해서는 회의 시간이 작은 애들이 많이 써야함 -> 작은 기준으로만 정렬을 하니 중간에 회의를 할 수 있어도 못하게 됨
-> 힌트 : 종료 시간을 기준으로 먼저 정렬해라
-> 아.. 종료 시간 후에 시작 시간을 기준으로 정렬해야함
반례 : 3
1 3
4 4
3 4
"""
N = input()
mettings = [tuple(map(int, input().split())) for _ in range(int(N))]

# 종료시간을 기준으로 정렬하는데 종료 시간이 같으면 회의 시간이 작은 순서대로 정렬하도록
mettings.sort(key=lambda x: (x[1], abs(x[0] - x[1])))
count = 0
endTime = 0
for i in mettings:
    if i[0] >= endTime:
        count += 1
        endTime = i[1]
print(count)
