# 남기는 것은 에너지 드링크가 가장 많이 있는 것이 될 것이다.
# 그래야 남는 에너지 드링크 총량이 최대가 될 것

import sys

n = int(sys.stdin.readline())
drink = list(map(int,sys.stdin.readline().split()))

# 최대 = 최대 값 + (나머지 값의 합)/2
maxd = max(drink)
# 최대값 제거
drink.remove(maxd)
print(sum(drink)/2 + maxd)