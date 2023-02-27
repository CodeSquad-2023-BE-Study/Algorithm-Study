package HyowonSin.Week_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2309_일곱난쟁이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> height = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            height.add(Integer.parseInt(br.readLine()));
        }
        BOJ_2309_일곱난쟁이 p = new BOJ_2309_일곱난쟁이();
        p.solution(height);
    }

    public void solution(ArrayList<Integer> height) {
        Collections.sort(height);
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += height.get(i);
        }
        loop:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (height.get(i) + height.get(j) == sum - 100) {
                    height.remove(j);
                    height.remove(i);
                    for (int k = 0; k < 7; k++) {
                        System.out.println(height.get(k));
                    }
                    break loop;
                }
            }
        }
    }
}