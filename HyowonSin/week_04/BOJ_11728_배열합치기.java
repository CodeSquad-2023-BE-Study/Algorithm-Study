package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> qA = new LinkedList<>();
        Queue<Integer> qB = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            qA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            qB.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        while (!qA.isEmpty() && !qB.isEmpty()) {
            if (qA.peek() < qB.peek()) {
                sb.append(qA.poll()).append(" ");
            } else {
                sb.append(qB.poll()).append(" ");
            }
        }

        while (!qA.isEmpty()) {
            sb.append(qA.poll()).append(" ");
        }
        while (!qB.isEmpty()) {
            sb.append(qB.poll()).append(" ");
       }
        System.out.println(sb);
    }
}
