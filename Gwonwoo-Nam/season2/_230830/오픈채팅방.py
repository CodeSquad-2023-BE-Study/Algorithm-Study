def solution(record):
    answer = []

    # user_id를 key로 가지는 dict

    user_dict = {}
    for e in record :
        splits = e.split()
        if len(splits) > 2 :
            command, user_id, nick_name = splits
        else :
            command, user_id = splits

        if command == "Enter" :
            user_dict[user_id] = nick_name
        elif command == "Change" :
            user_dict[user_id] = nick_name

    for e in record :
        splits = e.split()
        if len(splits) > 2 :
            command, user_id, nick_name = splits
        else :
            command, user_id = splits

        if command == "Enter" :
            answer.append(user_dict[user_id] + "님이 들어왔습니다.")

        elif command == "Leave" :
            answer.append(user_dict[user_id] + "님이 나갔습니다.")

    return answer
