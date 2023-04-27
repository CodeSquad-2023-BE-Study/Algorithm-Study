"""
입장 : 채팅 남긴 시간 <= 시작시간
퇴장 : 끝나는 시간 <= 채팅 남긴 시간 <= 스트리밍 끝나는 시간
"""
import sys
import time

checkTime = [time.strptime(x, "%H:%M") for x in sys.stdin.readline().strip().split()]
# chatting = {}
chatting = []
while True:
    try:
        chat = sys.stdin.readline().split()
        if not chat:
            break
        chatting.append([time.strptime(chat[0], "%H:%M"), chat[1]])
    except:
        break

# 입장한 사람
start = set(map(lambda x: x[1], filter(lambda x: x[0] <= checkTime[0], chatting)))

# 퇴장한 사람
end = set(map(lambda x: x[1], filter(lambda x: checkTime[1] <= x[0] <= checkTime[2], chatting)))

sys.stdout.write(str(len(start & end)))
