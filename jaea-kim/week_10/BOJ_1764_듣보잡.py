N, M = input().split()
name1 = set([input() for _ in range(int(N))])
name2 = set([input() for _ in range(int(M))])

result = list(name1.intersection(name2))
result.sort()

print(len(result))
print(*result, sep='\n')
