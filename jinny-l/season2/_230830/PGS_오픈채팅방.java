package season2._230830;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PGS_오픈채팅방 {

    public static String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        List<String> actionLog = new ArrayList<>();
        List<String> userLog = new ArrayList<>();
        Map<String, String> users = new LinkedHashMap<>();

        for (String s : record) {
            // record 파싱
            String[] tmp = s.split(" ");
            String action = tmp[0];
            String userId = tmp[1];

            // 로그 저장
            actionLog.add(action);
            userLog.add(userId);

            // 변경되는 유저 정보 저장
            if (action.equals("Change") || action.equals("Enter")) {
                String name = tmp[2];
                users.put(userId, name);
            }
        }

        // 로그를 기록으로 변환
        for (int i = 0; i < actionLog.size(); i++) {
            String action = actionLog.get(i);
            String userId = userLog.get(i);
            String name = users.get(userId);
            String log = generateLog(action, name);
            if (log != null) {
                answer.add(log);
            }
        }
        return answer.toArray(new String[]{});
    }

    private static String generateLog(String action, String name) {
        if (action.equals("Enter")) {
            return String.format("%s님이 들어왔습니다.", name);
        }
        if (action.equals("Leave")) {
            return String.format("%s님이 나갔습니다.", name);
        }
        return null;
    }
}
