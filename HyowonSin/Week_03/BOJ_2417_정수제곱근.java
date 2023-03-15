package Week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2417_정수제곱근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long q = (long) Math.sqrt(n);

        if (q * q < n) {
            System.out.println(q+1);
        } else {
            System.out.println(q);
        }
    }
}