import sys

word = sys.stdin.readline().strip()
result = [0] * len(word)
left = 0
right = len(word)
stack = [0]

while sum(result) < len(result):
    if sum(result[left:]) == len(result[left:]):
        right = left
        if len(stack) == 0:
            stack.append(0)
        left = stack[-1]
        del stack[-1]
    else:
        sub = word[left:right]
        left = left + sub.index(min(sub))

        stack.append(left)
        if result[left] == 0:
            result[left] = 1
            answer = ""
            for i in range(len(word)):
                if result[i] == 1:
                    answer += word[i]
            print(answer)

        if left+1 < len(word):
            left += 1
