import sys

data = sys.stdin.readline().strip()

max = ""
min = ""

pointer = 0
while pointer < len(data):
    if data[pointer] == "M":
        for i in range(pointer, len(data)):
            if data[i] == "K":
                max += "5"
                min += "1"
                max += "0" * (i - pointer)
                min += "0" * (i - pointer - 1)
                min += "5"
                pointer = i
                break
            if i == len(data)-1 and data[i] == "M":
                max += "1" * (i - pointer + 1)
                min += "1"
                min += "0" * (i - pointer)
                pointer = i

    elif data[pointer] == "K":
        max += "5"
        min += "5"
    pointer += 1

if "K" not in data:
    print("1" * (len(data)))
    print("1" + "0" * (len(data) - 1))
else:
    print(max)
    print(min)
