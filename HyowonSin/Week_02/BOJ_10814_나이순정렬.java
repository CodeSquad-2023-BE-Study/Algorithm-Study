package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][];

        for (int i=0; i<N; i++) {
            String[] node = new String[3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            node[0] = ""+i;
            node[1] = st.nextToken();
            node[2] = st.nextToken();
            arr[i] = node;
        }

        Arrays.sort(arr, Comparator.comparingInt((String[] o) -> Integer.parseInt(o[1])));

        for (int i=0; i<N; i++) {
            System.out.println(arr[i][1] + " " + arr[i][2]);
        }
    }
}
