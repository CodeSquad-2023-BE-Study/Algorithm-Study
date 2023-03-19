package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2118_두개의탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] points = new int[N];

        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += points[i];
        }

        int pointer = 0;
        int distance = 0;
        int maxDistance = 0;

        for (int i = 0; i < N; i++) {
            while (distance <= sum / 2) {
                pointer = (pointer + 1) % N;
                distance += points[pointer];
            }
            distance -= points[pointer];
            if (distance == sum / 2) {
                System.out.println(distance);
                return;
            } else if (distance <= sum / 2) {
                maxDistance = Math.max(distance, maxDistance);
                distance = 0;
            }
        }

        System.out.println(maxDistance);
    }
}
