n = int(input())

my = dict()
for i in range(n):
    str = input().split(".")[1]
    if (my.get(str) == None) :
        my[str] = 1
    else :
        my[str] += 1

list = sorted(my.items())
for i in range(len(list)):
    print(list[i][0] + " " +  "{}".format(list[i][1]))
