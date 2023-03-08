import sys

university_W = list()
university_K = list()

for _ in range(10):
    university_W.append(int(sys.stdin.readline()))

for _ in range(10):
    university_K.append(int(sys.stdin.readline()))

university_W.sort(reverse=True)
university_K.sort(reverse=True)

sum_W = university_W[0] + university_W[1] + university_W[2]
sum_K = university_K[0] + university_K[1] + university_K[2]
print(sum_W, sum_K)
