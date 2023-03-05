package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11650_좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] coords = new int[N][];

        for (int i = 0; i < N; i++) {
            int[] coord = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            coord[0] = Integer.parseInt(st.nextToken());
            coord[1] = Integer.parseInt(st.nextToken());
            coords[i] = coord;
        }

        Arrays.sort(coords, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(coords[i][0] + " " + coords[i][1]);
        }
    }
}
