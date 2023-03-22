package week_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        int[] a = new int[aSize];
        int[] b = new int[bSize];
        int[] result = new int[aSize + bSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int pointer1 = 0;
        int pointer2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (pointer1 == aSize) {
                result[i] = b[pointer2];
                pointer2++;
                continue;
            }
            if (pointer2 == bSize) {
                result[i] = a[pointer1];
                pointer1++;
                continue;
            }

            if (a[pointer1] > b[pointer2]) {
                result[i] = b[pointer2];
                pointer2++;
            } else if (a[pointer1] < b[pointer2]) {
                result[i] = a[pointer1];
                pointer1++;
            } else {
                result[i] = a[pointer1];
                result[++i] = b[pointer2];
                pointer1++;
                pointer2++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : result) {
           sb.append(n);
           sb.append(" ");
        }

        System.out.println(sb);
    }
}
