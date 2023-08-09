package season1.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 탑 입력하면서 수신 기능한 탑 확인
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());

            while (true) {
                if (stack.empty()) { // 수신 탑의 높이가 낮으면 계속 pop하기 때문에 스택이 비어있는지 확인해 준다.
                    sb.append(0).append(" ");
                    stack.push(new Tower(i + 1, current));
                    break;
                }

                Tower receivedTower = stack.peek();

                if (receivedTower.height < current) { // 수신 탑의 높이가 낮으면 pop하고 다른 수신탑을 찾을 때까지 반복문을 돈다.
                    stack.pop();
                }

                if (receivedTower.height > current) { // 수식 탑의 높이가 더 높으면, 위치를 저장하고 현재 tower도 push한다.
                    sb.append(receivedTower.index).append(" ");
                    stack.push(new Tower(i + 1, current));
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    static class Tower {
        int index;
        int height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
