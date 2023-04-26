"""
확장자 찾고 -> '.' 을 기준으로 split
해당 확장자 파일 수 찾기
* 시간초과 발생
원인 : fileName.count(extension) 사용해서 확장자 카운트 하였는데 시간복잡도가 O(n)
-> dict 형태로 확장자 - 갯수로 저장
"""
import sys

N = sys.stdin.readline()
extensions = {}
fileNames = [sys.stdin.readline().split('.')[1].strip() for _ in range(int(N))]

for fileName in fileNames:
    if fileName in extensions:
        extensions[fileName] += 1
    else:
        extensions[fileName] = 1

result = sorted(extensions.items())
for r in result:
    sys.stdout.write('%s %s\n' % (r[0], r[1]))
