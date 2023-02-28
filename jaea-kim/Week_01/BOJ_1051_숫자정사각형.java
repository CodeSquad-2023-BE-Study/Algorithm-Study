package Week_01;

import java.util.*;

public class BOJ_1051_숫자정사각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        int[][] rectangle = new int[m][n];
        for (int i = 0; i < m; i++) {
            char[] row = sc.nextLine().toCharArray();
            for (int j = 0; j < row.length; j++) {
                rectangle[i][j] = row[j] - '0';
            }
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (rectangle[i][j] == rectangle[i][k]) {
                        int sum = k - j;
                        if (i + sum > m - 1) {
                            continue;
                        }
                        if (rectangle[i][j] == rectangle[i + sum][j] && rectangle[i][j] == rectangle[i + sum][k]) {
                            results.add((sum + 1) * (sum + 1));
                        }
                    }
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println(1);
        } else {
            results.sort(Collections.reverseOrder());
            System.out.println(results.get(0));
        }
    }
}
