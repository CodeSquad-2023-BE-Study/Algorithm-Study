import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] arrayA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        int[] arrayB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();

        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder();
        while (i<n && j<m) {
            if (arrayA[i] < arrayB[j]) {
                sb.append(arrayA[i]);
                i++;
            }
            else {
                sb.append(arrayB[j]);
                j++;
            }
            sb.append(" ");
        }
        while (i<n) {
            sb.append(arrayA[i]);
            sb.append(" ");
            i++;
        }
        while (j<m) {
            sb.append(arrayB[j]);
            sb.append(" ");
            j++;
        }
        System.out.println(sb.toString().trim());
    }
}
