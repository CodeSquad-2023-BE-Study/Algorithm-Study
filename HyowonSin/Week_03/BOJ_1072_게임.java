package Week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int Z = (int) (((double) 100*Y / X));

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        int left = 0;
        int right = 1000000000;
        int mid = 1;

        while (left <= right) {
            mid = (left + right) / 2;
            int newZ = (int) (((double) 100*(Y + mid) / (X + mid)));

            if (newZ > Z) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}