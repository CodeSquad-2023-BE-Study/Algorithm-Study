import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] given = new String[n + 2][3];
        String[] tree = new String[(int)Math.pow(2, n) + 2];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            given[i][0] = stringTokenizer.nextToken();
            given[i][1] = stringTokenizer.nextToken();
            given[i][2] = stringTokenizer.nextToken();
        }

        tree[1] = "A";
        append(1,"A",given, tree, n);
        preOrder(1,tree);
        System.out.println();
        inOrder(1,tree);
        System.out.println();
        postOrder(1,tree);


    }

    public static void append(int index, String searchTarget, String[][] given, String[] tree, int n) {
        for (int i=0;i<n;i++) {
            if (given[i][0].equals(searchTarget)) {
                tree[2*index] = given[i][1];
                tree[2*index + 1] = given[i][2];
                //왼쪽 하위 노드 등록
                append(2*index, given[i][1], given, tree, n);
                //오른쪽 하위 노드 등록
                append(2*index+1,given[i][2], given, tree, n);
            }
        }
    }

    public static void postOrder(int index, String[] tree) {
        if (tree[index] != null && !tree[index].equals(".")) {
            if (tree[2*index] != null && !tree[2*index].equals(".")) {
                postOrder(2*index, tree);

            }
            if (tree[2*index+1] != null && !tree[2*index+1].equals(".")) {
                postOrder(2*index + 1, tree);
            }
            System.out.print(tree[index]);
        }
    }
    public static void preOrder(int index, String[] tree) {
        if (tree[index] != null && !tree[index].equals(".")) {
            System.out.print(tree[index]);
            if (tree[2*index] != null && !tree[2*index].equals(".")) {
                preOrder(2*index, tree);
            }
            if (tree[2*index+1] != null && !tree[2*index+1].equals(".")) {
                preOrder(2*index + 1, tree);
            }
        }
    }
    public static void inOrder(int index, String[] tree) {
        if (tree[index] != null && !tree[index].equals(".")) {
            if (tree[2*index] != null && !tree[2*index].equals(".")) {
                inOrder(2*index, tree);
            }
            System.out.print(tree[index]);
            if (tree[2*index+1] != null && !tree[2*index+1].equals(".")) {
                inOrder(2*index + 1, tree);
            }
        }
    }

}
