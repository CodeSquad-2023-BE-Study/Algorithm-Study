def solution(s):
    arr = []
    for i in range(1, len(s) + 1):
        index = 0
        count = 1
        temp = ""
        while True:
            if index+i >= len(s):
                if count != 1:
                    temp += str(count)
                temp += s[index:]
                break
            if s[index:index + i] == s[index + i:index + i + i]:
                count += 1
            else:
                if count != 1:
                    temp += str(count)
                temp += s[index:index+i]
                count = 1
            index += i
            if index == len(s) - 1:
                if count != 1:
                    temp += str(count)
                temp += s[index]
                break
        arr.append(temp)
    answer = min(map(lambda x: len(x), arr))
    return answer
