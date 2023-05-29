package week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 한 변의 길이
        int length = (int) Math.pow(2, N);

        search(length, x, y);
        System.out.println(count);
    }

    private static void search(int length, int x, int y) {
        if (length == 1) {
            return;
        }

        int newSize = length / 2;
        int quadrantSize = newSize * newSize;

        if (x < newSize && y >= newSize) { // 1사분면
            count += quadrantSize;
            search(newSize, x, y - newSize);
        }

        if (x < newSize && y < newSize) { // 2사분면
            search(newSize, x, y);
        }

        if (x >= newSize && y < newSize) { // 3사분면
            count += quadrantSize * 2;
            search(newSize, x - newSize, y);
        }

        if (x >= newSize && y >= newSize) { // 4사분면
            count += quadrantSize * 3;
            search(newSize, x - newSize, y - newSize);
        }

    }

}
