def solution(dartResult):
    for i in range(len(dartResult)):
        if not dartResult[i].isdigit():
            if dartResult[i] == 'S' or dartResult[i] == 'D' or dartResult[i] == 'T':
                if dartResult[i+1].isdigit():
                    dartResult = dartResult[:i+1] + ' ' + dartResult[i+1:]
                else:
                    dartResult = dartResult[:i+2] + ' ' + dartResult[i+2:]

    first, second, third = dartResult.split(' ')

    num1 = ""
    num2 = ""
    num3 = ""

    for item in first:
        if item.isdigit():
            num1 += item
        elif item == 'D':
            num1 = int(num1) ** 2
        elif item == 'T':
            num1 = int(num1) ** 3
        elif item == '*':
            num1 = int(num1) * 2
        elif item == '#':
            num1 = int(num1) * -1

    for item in second:
        if item.isdigit():
            num2 += item
        elif item == 'D':
            num2 = int(num2) ** 2
        elif item == 'T':
            num2 = int(num2) ** 3
        elif item == '*':
            num1 = int(num1) * 2
            num2 = int(num2) * 2
        elif item == '#':
            num2 = int(num2) * -1

    for item in third:
        if item.isdigit():
            num3 += item
        elif item == 'D':
            num3 = int(num3) ** 2
        elif item == 'T':
            num3 = int(num3) ** 3
        elif item == '*':
            num2 = int(num2) * 2
            num3 = int(num3) * 2
        elif item == '#':
            num3 = int(num3) * -1

    return int(num1) + int(num2) + int(num3)

print(solution('1D2S#10S'))