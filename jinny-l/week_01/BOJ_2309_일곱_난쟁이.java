package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 문제 풀이 방법:
 * 1. 9명 키의 합 계산
 * 2. 9명 키의 합 - 2명의 키 == 100인 경우 찾기
 * 3. 2명의 키일 경우 continue 하고 결과 출력
 * 주의: 오름차순으로 출력해야 하기 때문에 입력 or 출력 때 정렬 필요
 */

public class BOJ_2309_일곱_난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int[] dwarfs = new int[9];
        for (int i = 0; i < dwarfs.length; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        // 9명의 합 구하기
        int sum = 0;
        for (int dwarf : dwarfs) {
            sum += dwarf;
        }

        // 합 - 2명 키 = 100 인 경우 탐색
        loop:
        for (int i = 0; i < dwarfs.length - 1; i++) {
            for (int j = i + 1; j < dwarfs.length; j++) {
                if (sum - dwarfs[i] - dwarfs[j] == 100) {
                    dwarfs[i] = 0;
                    dwarfs[j] = 0;
                    break loop;
                }
            }
        }

        // 결과 출력
        Arrays.sort(dwarfs);  // !! 정렬
        for (int i = 2; i < dwarfs.length; i++) {
            System.out.println(dwarfs[i]);
        }
    }
}
