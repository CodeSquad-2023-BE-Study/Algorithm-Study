N = input()

P = list(map(int, input().split()))
P.sort()

result = [P[0]]
for i in range(1, int(N)):
    result.append(result[i - 1] + P[i])

print(sum(result))
