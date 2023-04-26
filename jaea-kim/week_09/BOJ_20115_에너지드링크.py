"""
합쳐진 에너지 드링크를 최대로 하기 위해서는 가장 작은 양의 드링크를 버려야하지 않을까?
가장 적은 양의 드링크를 가장 맣은 양의 드링크에게 붓자!
"""

N = input()
amount = list(map(int, input().split()))
amount.sort()

result = amount[-1]

for i in range(0, int(N) - 1):
    result += amount[i] / 2

print(result)

