package week_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20364_부동산다툼 {
    /*
    오리들이 서있는 순서대로 원하는 땅 겟
    가는 길에 점유된 땅이 있으면 실패

    땅 점유여부 확인 boolean[] visited
    * 고민 : 1부터 탐색하는게 좋을까? 오리가 원하는 지점부터 탐색하는게 좋을까?
        시도1 : 1부터 탐색 -> 실패 (현재 노드 기준으로 좌,우 값이 정해져 원하는 위치로 어느 방향으로 가야할지 모르겠음)

    * 출력
    오리별로 땅 점유하면 0
                못하면 처음 마주치는 점유된 땅의 번호
      */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        int[] wanted = new int[Q];

        for (int i = 0; i < Q; i++) {
            wanted[i] = Integer.parseInt(br.readLine());
        }

        for (int ground : wanted) {
            int index = ground;
            int result = Q + 1;
            while (index > 1) {
                if (!visited[index]) { //점유되지 않은 땅
                    index = index / 2;
                } else {
                    result = index;
                    index = index / 2;
                }
            }
            if (result != Q + 1) {
                System.out.println(result);
            } else if (index == 1) { //탐색완료
                System.out.println(0);
                visited[ground] = true;
            }
        }
    }

}
