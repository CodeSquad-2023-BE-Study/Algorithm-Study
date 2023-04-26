import sys

s,e,q = map(lambda s: int(s.replace(':','')), sys.stdin.readline().split(" "))

checker = dict()

while True :
  try:
    str = sys.stdin.readline()[:-1]
    t = int(str.split(" ")[0].replace(':',''))
    if checker.get(str.split(" ")[1]) == None and (t <= s) :
      checker[str.split(" ")[1]] = 1
    if checker.get(str.split(" ")[1]) == 1 and (t >= e and t <= q) :
      checker[str.split(" ")[1]] = 2
  except:
    break

sum = 0
for item in checker.items() :
  if item[1] == 2 :
    sum += 1

print(sum)
