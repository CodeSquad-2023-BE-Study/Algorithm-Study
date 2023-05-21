import sys

sl, sr = map(str, sys.stdin.readline().split())
string = sys.stdin.readline().split()[0]

dicL = {'q': [0, 2], 'w': [1, 2], 'e': [2, 2], 'r': [3, 2], 't': [4, 2],
        'a': [0, 1], 's': [1, 1], 'd': [2, 1], 'f': [3, 1], 'g': [4, 1],
        'z': [0, 0], 'x': [1, 0], 'c': [2, 0], 'v': [3, 0]}
dicR = {'!': [0, 2], 'y': [1, 2], 'u': [2, 2], 'i': [3, 2], 'o': [4, 2], 'p': [5, 2],
        '@': [0, 1], 'h': [1, 1], 'j': [2, 1], 'k': [3, 1], 'l': [4, 1],
        'b': [0, 0], 'n': [1, 0], 'm': [2, 0]}

result = 0
for token in list(string):
    slPoint = dicL[sl]
    srPoint = dicR[sr]
    if dicL.get(token) is not None:
        tokenPoint = dicL[token]
        temp01 = abs(slPoint[0] - tokenPoint[0]) + abs(slPoint[1] - tokenPoint[1])
        result += 1 + temp01
        sl = token
    else:
        tokenPoint = dicR[token]
        temp02 = abs(srPoint[0] - tokenPoint[0]) + abs(srPoint[1] - tokenPoint[1])
        result += 1 + temp02
        sr = token

print(result)
