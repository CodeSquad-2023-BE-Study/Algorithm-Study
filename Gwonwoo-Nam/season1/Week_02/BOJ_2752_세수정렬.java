import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ_2752_세수정렬 {

    /**
     * 문제 풀이
     * 1. 입력을 int의 배열에 저장
     * 2. Arrays.sort로 오름차순 정렬 후 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(input);
        System.out.println(Arrays.stream(input).mapToObj(a->Integer.toString(a)).collect(Collectors.joining(" ")));
    }
}
