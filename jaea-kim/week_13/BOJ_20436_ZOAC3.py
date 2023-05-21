'''
키보드 배열대로 이동하기 위해서는 키보드 리스트 필요, 자음 모음이 구분 되어야 하므로 따로 만듬
입력하려는 문자가 자음 or 모음 쪽인지 판단하고 손의 위치에서 거리 계산
'''
left, right = input().split()
strings = input()

leftKeyboard = ['qwert', 'asdfg', 'zxcv']
rightKeyboard = ['yuiop', 'hjkl', 'bnm']

lx = ly = rx = ry = None

for i in range(3):
    if left in leftKeyboard[i]:
        lx = i
        ly = leftKeyboard[i].index(left)

    if right in rightKeyboard[i]:
        rx = i
        ry = rightKeyboard[i].index(right)

time = 0;
for s in strings:
    for i in range(3):
        if s in leftKeyboard[i]:
            nx = i
            ny = leftKeyboard[i].index(s)
            time += 1 + abs(nx - lx) + abs(ny - ly)
            lx = nx
            ly = ny
            break;

        if s in rightKeyboard[i]:
            nx = i
            ny = rightKeyboard[i].index(s)
            time += 1 + abs(nx - rx) + abs(ny - ry)
            rx = nx
            ry = ny
            break;

print(time)
