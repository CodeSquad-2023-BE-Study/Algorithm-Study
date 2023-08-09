package week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크_연결 {

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int vertexCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());

        Vertex[] trees = new Vertex[edgeCnt];
        for (int i = 0; i < edgeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Vertex vertex = new Vertex();

            vertex.start = Integer.parseInt(st.nextToken());
            vertex.end = Integer.parseInt(st.nextToken());
            vertex.cost = Integer.parseInt(st.nextToken());

            trees[i] = vertex;
        }
        // 정렬
        Arrays.sort(trees, Comparator.comparingInt(o -> o.cost));

        // 부모 노드 초기화
        parents = new int[vertexCnt + 1];
        for (int i = 0; i <= vertexCnt; i++) {
            parents[i] = i;
        }

        // 크루스칼 알고리즘
        int cost = 0;
        for (int i = 0; i < edgeCnt; i++) {
            Vertex vertex = trees[i];
            int start = vertex.start;
            int end = vertex.end;

            if (!sameParent(start, end)) {
                union(start, end);
                cost += vertex.cost;
            }
        }
        System.out.println(cost);
    }

    static class Vertex {
        int start;
        int end;
        int cost;
    }

    private static boolean sameParent(int x, int y) {
        return find(x) == find(y);
    }

    private static int find(int vertex) {
        if (parents[vertex] == vertex) { // 여기도 왜 자기 자신일 떄는 그냥 돌아가는지 모르겠음
            return vertex;
        }
        return parents[vertex] = find(parents[vertex]);  // 여기 이해 못함
    }

    private static void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent > yParent) {
            parents[x] = yParent; // 여기 잘못됨
        } else {
            parents[y] = xParent;
        }
    }

}
