import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
public class BOJ_2531_회전초밥 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int d = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> arr = new ArrayList<>();

        for (int iter = 0; iter < n; iter++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        //k만큼 뒤에 추가하기
        for (int i = 0; i <= k; i++) {
            arr.add(arr.get(i));
        }

        int i = 0;
        int j = k;
        int max = 0;
        while (i < n) {
            int maxSize = setSize(arr,i,j,c);
            max = Math.max(max, maxSize);
            i++;
            j++;
        }

        System.out.println(max);
    }

    public static int setSize(List<Integer> arr, int i, int j, int c) {
        Set<Integer> set = new HashSet<>();
        for (int index=i; index<j;index++) {
            set.add(arr.get(index));
        }
        //쿠폰 추가
        set.add(c);
        //가짓수 리턴
        return set.size();
    }

}
