# 투 포인터로 한번에 처리하는 것이 포인트..

import sys

n = int(input())


def palindrome(str):
  i = 0
  j = len(str) - 1
  while (i < j):
    if (str[i] != str[j]):
      if (palindrome_pop(str, i + 1, j) or palindrome_pop(str, i, j - 1)) :
        return 1
      else :
        return 2
    i += 1
    j -= 1
  return 0

def palindrome_pop(str, i, j):
  while (i < j):
    if (str[i] != str[j]):
        return False
    i += 1
    j -= 1
  return True

for i in range(n):
  input = sys.stdin.readline().rstrip()
  print(palindrome(input))