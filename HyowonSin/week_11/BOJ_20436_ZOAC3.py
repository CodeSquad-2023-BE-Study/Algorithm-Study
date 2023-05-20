import sys

key1 = ['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p']
key2 = ['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l']
key3 = ['z', 'x', 'c', 'v', 'b', 'n', 'm']

keyboard = {}

for i in range(len(key1)):
    keyboard[key1[i]] = [0, i]
for i in range(len(key2)):
    keyboard[key2[i]] = [1, i]
for i in range(len(key3)):
    keyboard[key3[i]] = [2, i]

left, right = sys.stdin.readline().strip().split(" ")
word = sys.stdin.readline().strip()
result = 0


def distance(char1, char2):
    return abs(keyboard[char1][0] - keyboard[char2][0]) + abs(keyboard[char1][1] - keyboard[char2][1])


def check(char):
    if keyboard[char][0] == 0 and keyboard[char][1] < 5:
        return False
    elif keyboard[char][0] == 1 and keyboard[char][1] < 5:
        return False
    elif keyboard[char][0] == 2 and keyboard[char][1] < 4:
        return False
    else:
        return True


for i in word:
    if check(i):
        result += distance(i, right)
        right = i
    else:
        result += distance(i, left)
        left = i
    result += 1

print(result)
