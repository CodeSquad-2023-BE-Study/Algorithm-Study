package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * SimpleDateFormat 혹은 Date로 풀 경우, 시간초과 난다.
 * 인텔리제이 터미널에서 EOF로 탈출하고 싶으면 커맨드+D를 누르면 된다.
 */
public class BOJ_19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 시간 입력
        String start = st.nextToken();
        String end = st.nextToken();
        String streamingEnd = st.nextToken();

        // 전체 명단 입력, 입력 받으면서 출석, 퇴장 확인
        Map<String, Integer> result = new HashMap<>();
        String string;
        while ((string = br.readLine()) != null) {
            st = new StringTokenizer(string, " ");
            String time = st.nextToken();
            String name = st.nextToken();

            if (time.compareTo(start) <= 0) {  // 출석 확인
                result.put(name, 1);
            }

            if (time.compareTo(end) >= 0 && time.compareTo(streamingEnd) <= 0) {
                if (result.get(name) != null) { // 출석 명단에 있는 경우에만 퇴장 확인
                    result.put(name, result.getOrDefault(name, 0) + 1);
                }
            }
        }

        // Map value가 2이상인 값 카운팅
        long count = result.values().stream()
                .filter(value -> value >= 2)
                .count();

        System.out.println(count);
    }
}
