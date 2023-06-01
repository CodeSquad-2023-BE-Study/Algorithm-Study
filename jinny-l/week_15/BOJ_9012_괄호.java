package week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 개수 입력
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] brackets = br.readLine().split(""); // 괄호 입력
            sb.append(solve(brackets)); // 괄호 검사
        }
        System.out.print(sb);
    }

    private static String solve(String[] brackets) {
        Stack<String> stack = new Stack<>();

        if (brackets[0].equals(")") || brackets[brackets.length - 1].equals("(")) {
            return "NO\n";
        }

        for (int j = 0; j < brackets.length; j++) {
            if (brackets[j].equals("(")) {
                stack.push(brackets[j]);
            }
            if (stack.empty()) {
                return "NO\n";
            }
            if (brackets[j].equals(")")) {
                stack.pop();
            }
        }
        if (stack.empty()) {
            return "YES\n";
        }
        return "NO\n";
    }

}

