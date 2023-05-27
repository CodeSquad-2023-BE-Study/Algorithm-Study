'''
제일 작은 문 기준으로 뒤에 문자열 완성 후 앞에 문자열 완성 (사전 순으로 계속 작아야하니까)
'''

import sys

words = sys.stdin.readline().rstrip()


def sort(word, start, result):
    if word == "":
        return

    min_char = min(word)  # 최소 문자
    min_char_idx = word.index(min_char) # 최소 문자 위치

    result[start + min_char_idx] = min_char # 시작 위치 + 최소 문자 위치에 저장
    print(''.join(result))

    sort(word[min_char_idx + 1:], start + min_char_idx + 1, result) # 뒤에 문자열
    sort(word[:min_char_idx], start, result)

r = ['' for _ in range(len(words))]

sort(words, 0, r)
