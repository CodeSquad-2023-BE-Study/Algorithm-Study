n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

while len(board[-1]) != 1 : # board 길이가 1이면 종료
    new = []
    for i in range(0, len(board), 2) : # 가로 2칸
        temp = []
        for j in range(0, len(board), 2) : #세로 2칸
            result = sorted([board[i][j], board[i+1][j], board[i][j+1], board[i+1][j+1]], reverse = True) #가로2칸x세로2칸 오름차순 정렬
            temp.append(result[1])
        new.append(temp)
    board = new
print(board[0][0])