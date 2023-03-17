import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2118_두개의탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int iter = 0; iter < n; iter++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        long sum = arr.stream().reduce((a,b)->a+b).get();
        int a = 0;//첫점
        int b = n;//끝점
        long maxDistance = 0;

        for (a=0;a<n;a++) {
            long rightDistance = 0;
            long leftDistance = 0;
            long distance = 0;
            for (b=a+1;b<n;b++) {
                rightDistance += arr.get(b);
                leftDistance = sum - rightDistance;
                distance = Math.min(rightDistance,leftDistance);
                maxDistance = Math.max(distance, maxDistance);
                if (rightDistance > leftDistance) {
                    break ;
                }
            }
        }
        System.out.println(maxDistance);
    }
}
