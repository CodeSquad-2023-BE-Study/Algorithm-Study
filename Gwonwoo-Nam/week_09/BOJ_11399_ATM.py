import sys

n = int(sys.stdin.readline())
dp = [0 for i in range (n)]

arr = list(map(int, sys.stdin.readline().split()))
dp[0] = min(arr)
arr.remove(min(arr))

for i in range(1,n) :
  mini = min(arr)
  dp[i] = dp[i-1] + mini
  arr.remove(mini)

print(sum(dp))