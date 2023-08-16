import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1072_게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long x = xy[0];
        long y = xy[1];

        long low = 0; //초기 index
        long high = x + 1; //최소 x / 100판을 하면 승률이 변한다.
        long mid;
        while (low + 1 < high) {
            mid = (low + high) / 2;
            if ((y+mid)*100/(x+mid) == y*100/x) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        if (y*100/x >= 99) {
            System.out.println(-1);
            return;
        }
        System.out.println(high);

    }
}
