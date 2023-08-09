import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9372_상근이의여행 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testNo = 0; testNo < t; testNo++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken()); //가로
            int m = Integer.parseInt(stringTokenizer.nextToken()); //세로
            for (int i = 0; i < m; i++) {
                StringTokenizer getPlaneInfo = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(getPlaneInfo.nextToken());
                int b = Integer.parseInt(getPlaneInfo.nextToken());
            }

            System.out.println(n-1);
        }
    }
}
