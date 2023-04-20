n = int(input())

arr = []
for i in range (n) :
  a, b = map(int, input().split())
  arr.append([a,b])

arr.sort(key = lambda x: (x[1], x[0]))

# 초기 종료 시간
end = arr[0][1]
count = 1
for i in range(1, n) :
  if (arr[i][0] >= end) :
    count += 1
    end = arr[i][1]

print(count)