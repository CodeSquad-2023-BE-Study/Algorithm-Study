package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ingredients = new int[N];
        for (int i = 0; i < N; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingredients);

        int leftPointer = 0;
        int rightPointer = N - 1;
        int count = 0;

        while (leftPointer < rightPointer) {
            int sum = ingredients[leftPointer] + ingredients[rightPointer];
            if (sum == M) {
                count++;
                leftPointer++;
                rightPointer--;
            } else if (sum < M) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        System.out.println(count);
    }
}