import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3273_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());



        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int i=0;
        int j=0;
        int count=0;

        while (j < n-1 && array[j] < m) {
            j++;
        }
        while (i<j) {
            if (array[i] + array[j] == m) {
                count++;
                i++;
                j--;
            }
            else if (array[i] + array[j] > m) {
                j--;
            }
            else if (array[i] + array[j] < m) {
                i++;
            }
        }

        System.out.println(count);
    }
}
