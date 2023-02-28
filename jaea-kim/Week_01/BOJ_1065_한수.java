package Week_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1065_한수 {
    //public static void
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;

        loop:
        for (int i = 1; i <= input; i++) {
            List<Integer> digits = new ArrayList<>();
            int num = i;
            while (num != 0) {
                digits.add(num % 10);
                num /= 10;
            }

            if (digits.size() == 1 || digits.size() == 2) {
                count++;
                continue;
            }
            int sub = 0;
            for (int j = 0; j < digits.size() - 2; j++) {
                sub = digits.get(j) - digits.get(j + 1);
                if (digits.get(j + 1) - digits.get(j + 2) != sub) {
                    continue loop;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
