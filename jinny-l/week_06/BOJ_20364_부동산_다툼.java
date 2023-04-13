package week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * TODO: 한번 더 풀어보기
 * 밑에 노드부터 탐색해 올라가는 것이 효율적이라고는 하는데 막 이해되지는 않았다.
 */
public class BOJ_20364_부동산_다툼 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력: 땅 개수, 오리 수
        int vertexAmount = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 입력: 오리의 땅 번호
        int[] ducks = new int[Q];
        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = Integer.parseInt(br.readLine());
        }

        // 밑에서부터 위로 탐색
        Set<Integer> owners = new HashSet<>();
        for (int duck : ducks) {  // duck: 가야할 땅
            int owner = 0; // 땅 주인이 없을 경우 0으로 출력하기 위해 0으로 초기화

            for (int j = duck; j >= 2; j /= 2) { // 밑에서부터 부모 노드로 올라가는 중
                if (owners.contains(j)) {
                    owner = j;
                }
            }
            System.out.println(owner);
            owners.add(duck);
        }
    }
}
