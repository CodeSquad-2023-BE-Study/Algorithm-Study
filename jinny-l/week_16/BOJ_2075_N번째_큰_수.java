package week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075_N번째_큰_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 우선순위 큐로 입력
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (queue.size() == n) { // 우선순위 큐 크기가 N이면 큐 안에 있는 값과 비교
                    int cmp = queue.peek();

                    if (tmp > cmp) { // 새로운 값이 큐 안에 있는 값보다 크면 poll하고 add
                        queue.poll();
                        queue.add(tmp);
                    }
                } else { // 우선순위 큐 크기가 5보다 작으면 큐에 값을 넣는다.
                    queue.add(tmp);
                }
            }
        }

        System.out.println(queue.poll());
    }

}
