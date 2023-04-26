package week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * HashSet의 contains()는 O(1), ArrayList의 contains()는 O(n)이다.
 * HashSet은 map을 기반으로 구현되고, ArrayList는 indexOf()를 사용해서 contain 여부를 결정한다고 한다.
 * 참고: https://www.baeldung.com/java-hashset-arraylist-contains-performance
 * contains를 사용해서 문제를 풀려면 Set으로 입력받고 풀면 된다.
 */
public class BOJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 명단 입력
        Map<String, Integer> names = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            names.put(name, 1);
        }

        // 두번째 명단 입력 받으면서, 중복 이름 체크해서 List에 저장
        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            names.put(name, names.getOrDefault(name, 0) + 1); // 해당 이름이 이미 있다면 기존 값에 +1, 없다면 default로 0을 받고 +1

            if (names.get(name) == 2) {
                result.add(name);
            }
        }

        // 정렬 후 출력
        Collections.sort(result);
        System.out.println(result.size());
        result.forEach(name -> sb.append(name).append("\n"));
        System.out.println(sb);
    }
}
