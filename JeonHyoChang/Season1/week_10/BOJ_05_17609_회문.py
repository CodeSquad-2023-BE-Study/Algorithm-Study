import sys


def palindromeCheck(word):
    start = 0
    end = len(word) - 1

    while start < end:
        if word[start] == word[end]:
            start += 1
            end -= 1
        else:
            return word[start: end + 1]

    return ''


t = int(sys.stdin.readline())

palindrome = []
for _ in range(t):
    tempStr = sys.stdin.readline().split()[0]
    palindrome.append(tempStr)

for string in palindrome:
    temp01 = palindromeCheck(string)
    if temp01 == '':
        print(0)
    else:
        temp02 = palindromeCheck(temp01[1:])
        temp03 = palindromeCheck(temp01[:-1])
        if temp02 == '' or temp03 == '':
            print(1)
        else:
            print(2)
