import sys

T = int(sys.stdin.readline())

for _ in range(T):
    str = sys.stdin.readline().strip()

    left = 0
    right = len(str)-1
    count = 0

    while left < right:
        if str[left] == str[right]:
            left += 1
            right -= 1
        elif str[left+1] == str[right] and str[left] == str[right-1]:
            # 여기 처리 해줘야 할 것 같음?
            count += 0
        elif str[left+1] == str[right]:
            count += 1
            left += 1
        elif str[left] == str[right-1]:
            count += 1
            right -= 1
        else:
            count += 2

        if count > 1:
            break

    if count > 1:
        print(2)
    elif count == 1:
        print(1)
    else:
        print(0)
