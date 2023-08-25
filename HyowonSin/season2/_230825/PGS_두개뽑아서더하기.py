def solution(numbers):
    answer = set()

    arr = sorted(numbers)
    arr2 = set()

    for i in range(len(arr)-1):
        if arr[i] == arr[i+1]:
            arr2.add(arr[i])

    arr3 = list(set(arr))

    for i in range(len(arr3)):
        for j in range(i+1, len(arr3)):
            num = arr3[i] + arr3[j]
            answer.add(num)

    for i in arr2:
        answer.add(i+i)

    return sorted(list(answer))
