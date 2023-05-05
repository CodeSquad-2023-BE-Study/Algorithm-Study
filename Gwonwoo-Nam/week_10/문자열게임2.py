import sys
t = int(sys.stdin.readline())

# 3번 : 가장 짧은 연속 문자열 -> 반드시 처음과 끝의 문자가 동일하다.
# 4번 : 가장 짧은 연속 문자열 중 가장 긴 것


def getShortestString(str, target) :
  first = str[0]
  count = 0
  for i in range(len(str)) :
    if (str[i] == first) :
      count += 1
    if (target == count) :
      return i + 1
  return -1

for i in range(t) :
  str = sys.stdin.readline()
  target = int(sys.stdin.readline()[:-1])
  alpha = dict()
  for i in range(len(str)):
    if (str[i] not in alpha) :
      alpha[str[i]] = 1
    else :
      alpha[str[i]] += 1
  shortest = 9999999
  longest = -1
  for j in range(len(str)) :
    if (alpha.get(str[j]) < target) :
      continue
    tmp = getShortestString(str[j:], target)
    if (tmp > 0) :
      shortest = min(tmp , shortest)
      longest = max(tmp, longest)
  if (shortest == 9999999 and longest == -1) :
    print(-1)
  else :
    print("{} {}".format(shortest, longest))

