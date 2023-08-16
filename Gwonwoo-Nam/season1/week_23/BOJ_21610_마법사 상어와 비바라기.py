n,m = map(int, input().split())

board = []
cloud = [[0 for i in range(n)] for j in range(n)]
cloud[n-1][0] = 1
cloud[n-1][1] = 1
cloud[n-2][0] = 1
cloud[n-2][1] = 1
move = [[0, -1],[-1, -1], [-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1]]

def moveCloud(d, s, board,cloud) :
  dx, dy = move[d-1]
  dx *= s
  dy *= s
  check = [[0 for i in range(n)] for j in range(n)]
  for i in range(n) :
    for j in range(n) :
      if cloud[i][j] == 1 :
        r,c = i+dx, j+dy
        while r >= n :
          r -= n
        while r < 0 :
          r += n
        while c >= n :
          c -= n
        while c < 0 :
          c += n
        check[r][c] = 1
        cloud[i][j] = 0
  for i in range(n) :
      for j in range(n) :
        if check[i][j] == 1 :
          cloud[i][j] = 1
          board[i][j] += 1

def waterdup(d,s,board,cloud) :
  m = [[-1, -1], [-1,1],[1,1],[1,-1]]
  for i in range(n) :
    for j in range(n) :
      if cloud[i][j] == 1 :
        for dx, dy in m :
          if 0<=i+dx<n and 0<=j+dy<n and board[i+dx][j+dy] != 0 :
            board[i][j] += 1

def cloudtemp(d,s,board,cloud) :
  for i in range(n) :
    for j in range(n) :
      if board[i][j] >= 2 and cloud[i][j] != 1:
        cloud[i][j] = 1
        board[i][j] -= 2
      elif cloud[i][j] == 1 :
        cloud[i][j] = 0

for i in range(n) :
  r = list(map(int, input().split()))
  board.append(r)
for i in range(m) :
  d, s = map(int, input().split())

  moveCloud(d,s,board,cloud)
  waterdup(d,s,board,cloud)
  cloudtemp(d,s,board,cloud)

result = 0
for i in board :
  result += sum(i)
print(result)