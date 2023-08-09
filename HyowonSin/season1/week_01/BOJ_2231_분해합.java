package HyowonSin.Week_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2231_분해합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BOJ_2231_분해합 p = new BOJ_2231_분해합();
        System.out.println(p.solution(N));
    }

    public int solution(int N) {
        int lengthN = (int)(Math.log10(N)+1);
        int M = N - (lengthN*9);
        while(M<N) {
            int sum = 0;
            int left = M;
            while (left > 0) {
                sum += left % 10;
                left = left / 10;
            }
            if (M+sum == N) {
                return M;
            }
            M++;
        }
        return 0;
    }
}