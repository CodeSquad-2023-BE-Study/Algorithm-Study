import sys

n = int(sys.stdin.readline())

for _ in range(n):
    row = sys.stdin.readline().split()[0]

    if row[-1] != "(":
        stack = []
        for char in row:
            stack.append(char)
        # print(stack)

        checkStack = []
        while len(stack) != 0:
            if stack[-1] == ")":
                checkStack.append(stack.pop())

            if len(stack) > 0 and stack[-1] == "(":
                if len(checkStack) == 0:
                    break
                else:
                    checkStack.pop()
                    stack.pop()

        if len(stack) == 0 and len(checkStack) == 0:
            print("YES")
        else:
            print("NO")
    else:
        print("NO")
