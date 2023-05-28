import sys

N = int(sys.stdin.readline().strip())

MAP = []
for _ in range(N):
    MAP.append(list(map(int, sys.stdin.readline().strip().split(" "))))

white = 0
blue = 0


def cut_paper(MAP):
    global white
    global blue
    count = 0
    M = len(MAP)
    for i in range(M):
        count += sum(MAP[i])
        if count != 0 and count != M*(i+1):
            MAP1 = [[0 for j in range(M//2)] for i in range(M//2)]
            MAP2 = [[0 for j in range(M//2)] for i in range(M//2)]
            MAP3 = [[0 for j in range(M//2)] for i in range(M//2)]
            MAP4 = [[0 for j in range(M//2)] for i in range(M//2)]
            for j in range(M//2):
                for k in range(M//2):
                    MAP1[j][k] = MAP[j][k]
                    MAP2[j][k] = MAP[j][k+M//2]
                    MAP3[j][k] = MAP[j+M//2][k]
                    MAP4[j][k] = MAP[j+M//2][k+M//2]
            cut_paper(MAP1)
            cut_paper(MAP2)
            cut_paper(MAP3)
            cut_paper(MAP4)
            break

    if count == 0:
        white += 1
    elif count == M**2:
        blue += 1


cut_paper(MAP)
print(white)
print(blue)
