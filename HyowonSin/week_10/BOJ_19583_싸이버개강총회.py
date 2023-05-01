import sys

S, E, Q = sys.stdin.readline().split(" ")

admittedStudents = set()
exitedStudents = set()
answer = []

while 1:
    str = sys.stdin.readline().split(" ")
    if len(str) < 2:
        break
    else:
        time = str[0]
        name = str[1].strip()

    if time <= S:
        admittedStudents.add(name)
    if E <= time <= Q:
        exitedStudents.add(name)

answer = admittedStudents & exitedStudents

print(len(answer))
