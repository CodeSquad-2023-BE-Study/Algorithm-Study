package week_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9934_완전이진트리 {
    /*
    입력
    * K ; 깊이 -> 노드 수 : 2의 k승 -1 (모든 노드가 2개의 자식이 있거나 아예 없음)
    * int[] visit : 방문한 빌딩의 번호 순서 <- 중위 순회 방식
    전체 노드의 중간 노드가 루트 노드
    깊이 1 -> 루트 노드
    깊이 2 -> 루트 노드의 자식 노드 2개
    깊이 3 -> 자식 노드의 자식 노드 2*2개

    * 시도1. 노드 클래스를 만들어서 사용하려고 했더니.. 너무 비효율적
    * 시도2. 깊이별로 바로 출력할 수 없을까
        -> 부모노드 큐에 넣어 좌우 출력

    * 출력
    깊이 별로 노드 값 한 줄로 출력
    */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int nodeNum = (int) Math.pow(2, K) - 1;
        int[] visit = new int[nodeNum];
        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < visit.length; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }

        int mid = nodeNum / 2;
        int d = (mid / 2) + 1;
        q.add(mid);
        int depth = 1;
        int parent = 0;
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                parent = q.poll();
                System.out.print(visit[parent] + " ");

                q.add(parent - d);
                q.add(parent + d);
                //System.out.print(visit[parent + (d[j] * depth)]);
            }
            System.out.println();
            depth++;
            d = d / 2;
            if (depth == K + 1) {
                break;
            }
        }
    }

}
