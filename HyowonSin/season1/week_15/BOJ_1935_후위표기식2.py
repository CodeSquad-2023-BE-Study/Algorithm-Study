import sys

N = int(sys.stdin.readline().strip())

data = sys.stdin.readline().strip()
value = {}
for i in range(N):
    num = int(sys.stdin.readline().strip())
    value[chr(i+65)] = num

stack = []

for item in data:
    if item not in ['+', '-', '*', '/']:
        stack.append(value[item])
    else:
        op1 = stack.pop()
        op2 = stack.pop()

        if item == '+':
            stack.append(op2 + op1)
        elif item == '*':
            stack.append(op2 * op1)
        elif item == '-':
            stack.append(op2 - op1)
        elif item == '/':
            stack.append(op2 / op1)

print(format(stack.pop(), ".2f"))
