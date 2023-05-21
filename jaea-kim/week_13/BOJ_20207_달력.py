'''
다음 col가 없을 때까지 최대 row값 기억 -> row * col 가 넓이
'''
n = int(input())
canlender = [0] * 366 # 1 ~ 365일

for _ in range(n):
    start, end = map(int, input().split(' '))

    for i in range(start, end + 1):
        canlender[i] += 1 # 해당 날짜 일정 + 1

row = 0 # 최대 일정 수
col = 0 # 가로 길이
answer = 0
for i in range(366):
    if canlender[i] != 0: # 일정 있음
        row = max(row, canlender[i])
        col += 1
    else: #일정 없음
        answer += row * col
        row = 0
        col = 0
answer += row * col
print(answer)
