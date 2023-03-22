package week_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(sequence);

        int pointer1 = 0;
        int pointer2 = n - 1;
        int count = 0;

        while (pointer1 < pointer2) {
            if (sequence[pointer1] + sequence[pointer2] > x) {
                pointer2--;
            } else if (sequence[pointer1] + sequence[pointer2] < x) {
                pointer1++;
            } else {
                count++;
                pointer1++;
                pointer2--;
            }
        }
        System.out.println(count);
    }
}
