'''
범위 1 ~ N 중 중복없이 M개 고르기
재귀함수 이용해서
'''
n, m = list(map(int, input().split()))
result = []


def dfs():
    if len(result) == m:
        print(' '.join(map(str, result)))
        return

    for i in range(1, n+1):
        if i not in result:
            result.append(i)
            dfs()
            result.pop()

dfs()
