package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2752_세수정렬 {
    public static void main(String[] args) throws IOException {
        Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ")).map(Integer::parseInt).sorted().forEach(s -> System.out.print(s + " "));
    }
}