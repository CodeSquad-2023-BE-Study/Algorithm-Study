package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2531_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N + k - 1];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i < N + k - 1; i++) {
            sushi[i] = sushi[i - N];
        }

        HashSet<Integer> count = new HashSet<>();
        count.add(c);
        int max = count.size();

        for (int i = 0; i < N; i++) {
            for (int j = i; j < i + k; j++) {
                count.add(sushi[j]);
            }
            max = Math.max(max, count.size());
            count.clear();
            count.add(c);
        }

        System.out.println(max);
    }
}