package Week_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
    /*
    모든 수의 범위 : int
    1줄 : 탐색가능한 수 n
    2줄 : n개의 정수값
    3줄 : 탐색해야할 수 m
    4줄 : m개의 정수값
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];
        boolean[] result = new boolean[m];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        /*
        이진 탐색 알고리즘
        1. 배열의 중간 값을 가져옴
        2. 중간 값과 검색 값을 비교
            1. 중간 값이 검색 값과 같다면 종료
            2. 중간 값보다 검색 값이 크다면 배열의 오른쪽 구간을 대상으로 탐색
            3. 중간 값보다 검색 값이 작다면 배열의 왼쪽 구간을 탐색
        3. 값을 찾거나 간격이 비어있을 때까지 반복
         */
        for (int i = 0; i < target.length; i++) {
            int low = 0;
            int high = num.length - 1;
            while (true) {
                int mid = low + (high - low) / 2;
                if (num[mid] == target[i]) {
                    result[i] = true;
                    break;
                } else if (num[mid] < target[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                if (low > high) {
                    result[i] = false;
                    break;
                }
            }
        }

        for (boolean r : result) {
            System.out.println(r ? 1 : 0);
        }
    }
}
