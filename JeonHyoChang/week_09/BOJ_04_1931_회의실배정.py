import sys

n = int(sys.stdin.readline())

roomList = []
for _ in range(n):
    roomList.append(list(map(int, sys.stdin.readline().split())))

roomList.sort()

roomNum = 0
result = [roomList[0]]
for i in range(1, len(roomList)):
    if (roomList[i][0] >= result[roomNum][0]) \
            and (roomList[i][1] <= result[roomNum][1]):
        if result[roomNum][1] == roomList[i][0] \
                and result[roomNum][1] == roomList[i][1]:
            result.append(roomList[i])
            roomNum += 1
        else:
            result[roomNum] = roomList[i]
    elif roomList[i][0] >= result[roomNum][1]:
        result.append(roomList[i])
        roomNum += 1

print(roomNum + 1)
