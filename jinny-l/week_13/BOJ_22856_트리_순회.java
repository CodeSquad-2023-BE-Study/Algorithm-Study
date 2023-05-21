package week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_22856_트리_순회 {

    private static Map<Integer, ChildNode> nodes;
    private static boolean[] visited;
    private static int count = 0;
    private static int finalNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int nodeAmount = Integer.parseInt(br.readLine());
        nodes = new HashMap<>();

        for (int i = 1; i < nodeAmount + 1; i++) {
            String[] tmp = br.readLine().split(" ");
            int node = Integer.parseInt(tmp[0]);
            ChildNode childNode = new ChildNode(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
            nodes.put(node, childNode);

            finalNode = Math.max(finalNode, node); // 마지막 노드 찾기
        }

        // 트리 순회
        visited = new boolean[nodeAmount + 1];
        search(1);

        System.out.println(count);
    }

    private static void search(int start) {
        visited[start] = true;
        ChildNode childNode = nodes.get(start);
        int left = childNode.left;
        int right = childNode.right;

        if (start == finalNode) {
            count++; // 이거 확인
            return;
        }

        if (left == -1 || right == -1) {
            count++;
            int parentNode = findParentNode(start);
            search(parentNode);
        }

        if (!visited[left]) {
            count++;
            search(left);
        }

        if (!visited[right]) {
            count++;
            search(right);
        }

        if (visited[left]) {
            count++;
            int parentNode = findParentNode(start);
            search(parentNode);
        }

        if (visited[right]) {
            count++;
            int parentNode = findParentNode(start);
            search(parentNode);
        }
    }

    private static int findParentNode(int childNode) {
        if (childNode == 1) {
            return 1;
        }

        for (int i = 1; i < nodes.size(); i++) {
            ChildNode tmp = nodes.get(i);
            if (tmp.left == childNode || tmp.right == childNode) {
                return i;
            }
        }
        return -1; // 부모노드를 못찾았을 때 임의 값
    }

    static class ChildNode {

        private final int left;
        private final int right;

        public ChildNode(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}
