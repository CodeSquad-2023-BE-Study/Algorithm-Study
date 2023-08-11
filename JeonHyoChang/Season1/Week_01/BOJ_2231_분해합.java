import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int getSum(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }

        return list.stream().reduce(0, Integer::sum);
    }

    public static int getMaxSum(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            list.add(9);
            num /= 10;
        }

        return list.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int maxSum = getMaxSum(num);

        if (num / 10 == 0) {
            if (num == 2) System.out.println(1);
            else if (num == 4) System.out.println(2);
            else if (num == 6) System.out.println(3);
            else if (num == 8) System.out.println(4);
            else System.out.println(0);

        } else {
            int tempNum = num - maxSum;

            while (tempNum < num) {
                if (tempNum + getSum(tempNum) == num)
                    break;

                tempNum++;
            }

            if (tempNum == num) tempNum = 0;

            System.out.println(tempNum);
        }
    }
}
