import sys

MK = sys.stdin.readline()


def maxMK(MK):
    result = ''
    mCount = 0
    for i in range(len(MK) - 1):
        if MK[i] == 'M':
            mCount += 1
        else:
            result += str((10 ** mCount) * 5)
            mCount = 0

    result += '1' * mCount

    return result


def minMK(MK):
    result = ''
    mCount = 0
    for i in range(len(MK) - 1):
        if MK[i] == 'M':
            mCount += 1
        elif mCount > 0 and MK[i] == 'K':
            result += str(10 ** (mCount - 1))
            result += str(5)
            mCount = 0
        else:
            result += str(5)

    if mCount > 0:
        result += str(10 ** (mCount - 1))

    return result


print(maxMK(MK))
print(minMK(MK))
