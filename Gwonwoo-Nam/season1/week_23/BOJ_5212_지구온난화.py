r,c = map(int, input().split())

def check(i,j, li) :
  dir = [[1,0], [0,1], [-1,0], [0, -1]]
  t = 0
  for dx, dy in dir :
    if i+dx < r and i+dx >= 0 and j+dy < c and j+dy >= 0 :
      if li[i+dx][j+dy] == '.' :
        t += 1
    else :
      t += 1
  if t >= 3 :
    return True
  return False


li = []
for i in range(r) :
  li.append(list(input()))

for i in range(r) :
  for j in range(c) :
    if li[i][j] == 'X' :
      if check(i,j, li) :
        li[i][j] = 'O'

minr = 100
minc = 100
maxr = 0
maxc = 0
for i in range(r) :
  for j in range(c) :
    if li[i][j] == 'O' :
      li[i][j] = '.'
    if li[i][j] == 'X' :
      minr = min(minr, i)
      minc = min(minc, j)
      maxr = max(maxr, i)
      maxc = max(maxc, j)

for i in range(minr, maxr+1) :
  for j in range(minc, maxc+1) :
    print(li[i][j], end='')
  print()


