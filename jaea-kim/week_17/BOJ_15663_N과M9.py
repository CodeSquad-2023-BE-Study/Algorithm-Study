'''
범위 1 ~ N 중 M개 고르기
입력 2 : N 개의 수
N개의 수 안에 중복된 수가 존재 -> 직전에 선택된 수와 같으면 무시
'''
n, m = map(int, input().split())
nRange = list(map(int, input().split()))
nRange.sort()
visited = [False for _ in range(n)]
result = []

def dfs():
    if len(result) == m:
        print(' '.join(map(str, result)))
        return

    temp = 0
    for i in range(n):
        if (not visited[i]) and (temp != nRange[i]):
            visited[i] = True
            result.append(nRange[i])
            temp = nRange[i]
            dfs()
            visited[i] = False
            result.pop()

dfs()

