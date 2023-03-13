package Week_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
    /*
     절단기 높이 : H >= 0
     가져가는 나무 높이 : 나무 높이 - H <= 나무높이
     총 가져가는 나무 높이 >= M
     절단기의 최대높이 -> 가져가는 나무 최대한 작게
     */
    public static long getTakenLength(int mid, int[] treeHeight) {
        long result = 0;
        for (int i = 0; i < treeHeight.length; i++) {
            if (treeHeight[i] > mid) {
                result += (treeHeight[i] - mid);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeNum = Integer.parseInt(st.nextToken());
        int takenTreeHeight = Integer.parseInt(st.nextToken());
        int[] treeHeight = new int[treeNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <treeHeight.length; i++) {
            treeHeight[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = Arrays.stream(treeHeight).max().getAsInt();
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (getTakenLength(mid, treeHeight) >= takenTreeHeight) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
