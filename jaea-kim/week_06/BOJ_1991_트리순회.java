package week_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
    /*
    입력
    N : 노드의 개수
    (현재 노드 왼쪽 노드 오른쪽 노드) * N

    루트 노드 : A
    입력 받은 노드를 루트 노드부터 좌,우로 찾아서 연결! -> connect()
     */
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Node root = new Node("A");
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Node node = new Node(st.nextToken());
            String left = st.nextToken();
            String right = st.nextToken();

            if (left.equals(".") && right.equals(".")) { //노드 연결 필요 없음
                continue;
            }

            if (root.equals(node)) { //루트 노드와 입력된 노드가 일치하면
                if (!left.equals(".")) {
                    root.setLeftNode(new Node(left));
                }
                if (!right.equals(".")) {
                    root.setRightNode(new Node(right));
                }
            } else {
                //왼쪽 노드와 연결됐는지 확인
                connect(root.left, node, left, right);
                //오른쪽 노드와 연결됐는지 확인
                connect(root.right, node, left, right);
            }
        }

        System.out.println(preOrder(root));
        sb.setLength(0);
        System.out.println(inOrder(root));
        sb.setLength(0);
        System.out.println(postOrder(root));
    }

    public static void connect(Node node1, Node node, String left, String right) {
        if (node1 == null) {
            return;
        }
        if (node1.equals(node)) {
            if (!left.equals(".")) {
                node1.setLeftNode(new Node(left));
            }
            if (!right.equals(".")) {
                node1.setRightNode(new Node(right));
            }
        } else {
            connect(node1.left, node, left, right);
            connect(node1.right, node, left, right);
        }
    }

    //전위순회
    public static String preOrder(Node node) {
        if (node != null) {
            sb.append(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
        return sb.toString();
    }

    //중위순회
    public static String inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            sb.append(node.data);
            inOrder(node.right);
        }
        return sb.toString();
    }

    //후휘순회
    public static String postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            sb.append(node.data);
        }
        return sb.toString();
    }
}

class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setLeftNode(Node left) {
        this.left = left;
    }

    public void setRightNode(Node right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return data.equals(node.data);
    }
}
