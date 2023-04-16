import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        // n[3] =4
        // n[4] = 3 + 1, 1 + 3, 2 + 2;7
        // n[5] = 4 + 1, 1 + 4, 2 + 3, 3 + 2; 2*n[4]*n[1] + 2*[3]*n[2] +
        // n[6] = 5 + 1, 1 + 5, 4 + 2, 2 + 4, 3 + 3;
        // n[7] = 1 + 6, 6 + 1, 5 + 2, 2 + 5, 3 + 4, 4 + 3;
        // n[8] = sigma(n[7]*n[1] ~ n[1])
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] n = new int[11];
        n[1] = 1;
        n[2] = 2;
        n[3] = 4;

        int i=0;
        for (i=4;i<11;i++) {
            for (int j=1; j<4; j++) {
                if (i >= j)
                n[i] += n[i-j];
            }
        }
        for (int tc =0;tc<t;tc++) {
            int r = Integer.parseInt(br.readLine());
            System.out.println(n[r]);
        }


    }
}
