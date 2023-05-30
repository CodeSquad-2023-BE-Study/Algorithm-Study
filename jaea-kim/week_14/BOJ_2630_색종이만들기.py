'''
정사각형 종이 자르기
1. 종이가 다른 색이면 -> 2/N x 2/N 으로 4개 만들기
앞에 과정을 반복 -> 정사각형이 모두 같은 색일 때까지

입력
N : 첫 종이의 길이 최대 128
각 위치의 색 표시 흰색 0 파란색 1
출력
하얀색 색종이 길이
파란색 색종이 길이
'''

N = int(input())
paper = [list(map(int,input().split())) for _ in range(N)]

result = []

def cut(x, y, N) :
    color = paper[x][y]
    for i in range(x, x+N) :
        for j in range(y, y+N) :
            if color != paper[i][j] :
                cut(x, y, N // 2)
                cut(x, y + N // 2, N // 2)
                cut(x + N // 2, y, N // 2)
                cut(x + N // 2, y + N // 2, N // 2)
                return
    if color == 0 :
        result.append(0)
    else :
        result.append(1)


cut(0, 0, N)
print(result.count(0))
print(result.count(1))

