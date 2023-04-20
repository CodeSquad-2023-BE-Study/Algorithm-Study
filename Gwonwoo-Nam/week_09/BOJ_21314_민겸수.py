# 민겸수를 변환하는 방식이 바뀌더라도, 자릿수가 변화하지 않는다.
# 따라서 앞에서부터 최대가 되는 변환을 선택하면 자연스럽게 최대 값이 될 것이다.

import sys

str = sys.stdin.readline()[:-1]

i = 0

result = ""
while i < len(str) :
  n = 0
  answer = 1
  while i < len(str) :
    if str[i] == "M":
      n += 1
    else :
      n += 1
      answer *= 5
      break ;
    i += 1
  if (i == len(str) and str[i-1] == "M") :
    result = result + "{}".format("1"*n)
    break
  answer = answer * pow(10, n-1)
  i += 1
  result = result + "{}".format(answer)

print(result)
i = 0
result = ""
while i < len(str) :
  n = 0
  answer = 1
  while i < len(str) :
    if str[i] == "M":
      n += 1
    else :
      break ;
    i += 1
  if (n-1 >=0 ) :
    answer = answer * pow(10, n-1)
    result = result + "{}".format(answer)
  if i < len(str) and str[i] == "K" :
    answer = 5
    result = result + "{}".format(answer)
  i += 1

print(result)