package season1.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 택시거리..?가 뭐지
 */
public class BOJ_20436_ZOAC_3 {

    private static List<List<String>> left = List.of(
            List.of("q", "w", "e", "r", "t"),
            List.of("a", "s", "d", "f", "g"),
            List.of("z", "x", "c", "v")
    );

    private static List<List<String>> right = List.of(
            List.of("y", "u", "i", "o", "p"),
            List.of("h", "j", "k", "l"),
            List.of("b", "n", "m")
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력 받기
        String leftStart = st.nextToken();
        String rightStart = st.nextToken();
        String word = br.readLine();

        // 키보드 만들기
        Map<String, Axis> keyboard = makeKeyboard();

        // 결과 값
        int result = 0;

        // 시간 계산
        for (int i = 0; i < word.length(); i++) {
            String current = Character.toString(word.charAt(i));
            int time;

            if (isLeft(current)) {
                time = calculateTime(keyboard.get(leftStart), keyboard.get(current));
                leftStart = current;
            } else {
                time = calculateTime(keyboard.get(rightStart), keyboard.get(current));
                rightStart = current;
            }
            result += time;
        }

        System.out.println(result);
    }

    private static boolean isLeft(String alpha) {
        for (List<String> oneLine : left) {
            if (oneLine.contains(alpha)) {
                return true;
            }
        }
        return false;
    }

    private static int calculateTime(Axis current, Axis next) {
        return Math.abs(current.x - next.x) + Math.abs(current.y - next.y) + 1; // 택시 시간 + 누르는 시간
    }

    private static Map<String, Axis> makeKeyboard() {
        Map<String, Axis> keyboard = new HashMap<>();

        for (int i = 0; i < left.size(); i++) {
            List<String> oneLine = left.get(i);

            for (int j = 0; j < oneLine.size(); j++) {
                keyboard.put(oneLine.get(j), new Axis(i + 1, j + 1));
            }
        }

        for (int i = 0; i < right.size(); i++) {
            List<String> oneLine = right.get(i);
            int y = left.get(i).size();

            for (int j = 0; j < oneLine.size(); j++) {
                keyboard.put(oneLine.get(j), new Axis(i + 1, j + y));
            }
        }
        return keyboard;
    }

    static class Axis {
        int x;
        int y;

        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
