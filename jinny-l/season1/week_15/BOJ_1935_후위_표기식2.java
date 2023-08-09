package season1.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935_후위_표기식2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 계산식 입력
        String notation = br.readLine();

        // 값 입력
        double[] values = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        // 계산식 파싱, 숫자는 스택에 넣고 연산자 나오면 계산
        int valueIndex = 0;
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < notation.length(); i++) {
            if (Character.isAlphabetic(notation.charAt(i))) {
                stack.push(values[notation.charAt(i) - 'A']);
                valueIndex++;
            } else {
                double result = calculate(stack.pop(), stack.pop(), Character.toString(notation.charAt(i)));
                stack.push(result);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }

    private static double calculate(double x, double y, String operator) {
        if (operator.equals("+")) {
            return x + y;
        }
        if (operator.equals("-")) {
            return y - x;
        }
        if (operator.equals("*")) {
            return x * y;
        }
        return y / x;
    }

}
