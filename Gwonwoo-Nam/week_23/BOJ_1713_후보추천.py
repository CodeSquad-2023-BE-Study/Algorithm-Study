from collections import OrderedDict

n = int(input())
m = int(input())
numbers = map(int, input().split())

hit = OrderedDict()
for i in numbers :
  if len(hit) < n :
    if i not in hit.keys() :
      hit[i] = 1
    else :
      hit[i] += 1
  else :
    if i not in hit.keys() :
      key = list(hit.keys())
      val = list(hit.values())
      idx = val.index(min(val))
      del(hit[key[idx]])
      hit[i] = 1
    else :
      hit[i] += 1

print(" ".join(map(str,sorted(hit.keys()))))