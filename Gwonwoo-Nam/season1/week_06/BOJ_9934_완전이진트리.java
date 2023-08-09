import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934_완전이진트리 {
    private static int currentLoc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int border = (int)Math.round(Math.pow(2, k));
        int[] visited = new int[1024 + 1];
        //1~2^10 범위
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        currentLoc = 1;

        while (stringTokenizer.hasMoreTokens()) {
            int buildingIndex = Integer.parseInt(stringTokenizer.nextToken());
            visit(border, visited, buildingIndex);

        }

        //출력
        int rowSize = 1;
        int index=0;
        for (int i = 1; i < border; i++) {
            System.out.print(visited[i] + " ");
            index++;
            if (index == rowSize) {
                System.out.println();
                rowSize*=2;
                index=0;
            }
        }
    }

    public static void visit(int border, int[] visited, int buildingIndex) {
        while (visited[border - 1] == 0) {
            //현재 노드가 마지막 레벨이면 상위 노드로 이동
            if (currentLoc * 2 >= border) {
                visited[currentLoc] = buildingIndex;
                currentLoc /= 2;
                return ;
            }
            //왼쪽 하위 빌딩을 방문하지 않았으면
            if (visited[currentLoc * 2] == 0) {
                currentLoc *= 2;
                continue;
            }
            //현재 빌딩을 방문하지 않았으면
            if (visited[currentLoc] == 0) {
                visited[currentLoc] = buildingIndex;
                return;
            }
            //오른쪽 하위 빌딩을 방문하지 않았으면
            if (visited[currentLoc * 2 + 1] == 0) {
                currentLoc = currentLoc * 2 + 1;
                continue;
            }
            //다 방문되어있으면 부모노드로 이동
            currentLoc /= 2;
        }
    }
}
