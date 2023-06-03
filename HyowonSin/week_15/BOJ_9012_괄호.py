import sys

T = int(sys.stdin.readline().strip())


for _ in range(T):
    data = sys.stdin.readline().strip()

    stack = []

    for item in data:
        if item == '(':
            stack.append('(')
        elif len(stack) != 0:
            stack.pop()
        else:
            stack.append('end')
            break
    if len(stack) == 0:
        print('YES')
    else:
        print('NO')
