package season1.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// PriorityQueue를 사용해서 두개의 큐를 사용해서 풀이 시, remove로 인해 시간초과 발생
// TreeMap은 흑적나무로 구현되어 있어서 양쪽 끝단의 숫자를 O(1)로 꺼내올 수 있다.
public class BOJ_7662_이중_우선순위_큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테케 입력
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) { // 테케만큼 반복

            // 개수 입력
            int n = Integer.parseInt(br.readLine());

            // 트리맵으로 저장
            TreeMap<Integer, Integer> map = new TreeMap<>(); // Key: 숫자, Value: 개수

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String operator = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (operator.equals("I")) {
                    map.put(number, map.getOrDefault(number, 0) + 1);
                    continue;
                }

                if (operator.equals("D")) {
                    if (map.size() < 1) { // 맵이 비어있으면 무시
                        continue;
                    }

                    // 맵이 비어있지 않다면 min or max 값 찾기
                    int toDelete = number == 1 ? map.lastKey() : map.firstKey();
                    int value = map.get(toDelete);

                    if (value == 1) { // 삭제했을 때 값이 0이면 삭제
                        map.remove(toDelete);
                    } else { // 값이 0이 아니면 value -1
                        map.put(toDelete, map.getOrDefault(toDelete, 0) - 1);
                    }
                }
            }
            if (map.size() < 1) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey())
                        .append(" ")
                        .append(map.firstKey())
                        .append("\n");
            }
        }
        System.out.print(sb);
    }
}
