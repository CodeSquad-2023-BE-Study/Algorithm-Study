import sys

N = int(sys.stdin.readline())
user_list = list()

for _ in range(N):
    age, name = map(str, sys.stdin.readline().split())
    age = int(age)
    user_list.append((age, name))

user_list.sort(key=lambda x: x[0])

for e in user_list:
    print(e[0], e[1])
