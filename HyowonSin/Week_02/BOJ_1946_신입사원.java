package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; T++) {

            int N = Integer.parseInt(br.readLine());
            int count = N;
            int[][] arr = new int[N][];

            for (int j=0; j<N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] orders = new int[2];
                orders[0] = Integer.parseInt(st.nextToken());
                orders[1] = Integer.parseInt(st.nextToken());
                arr[j] = orders;
            }

            Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);

            for (int j=0; j<N; j++) {
                for (int k=j+1; k<N; k++) {
                    if (arr[k][1] < arr[j][1]) {
                        count--;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}