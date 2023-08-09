import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20364_부동산다툼 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken()); //가로
        int q = Integer.parseInt(stringTokenizer.nextToken()); //

        boolean[] occupied = new boolean[n + 1];
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            int loc = x;
            occupy(occupied, loc, x);
        }
    }

    private static void occupy(boolean[] occupied, int loc, int x) {
        int minOccupiedLocation = 0;
        while (loc > 1) {
            if (occupied[loc]) {
                minOccupiedLocation = loc;
            }
            loc /= 2;
        }
        if (minOccupiedLocation != 0) {
            System.out.println(minOccupiedLocation);
            return;
        }
        occupied[x] = true;
        System.out.println(0);
    }
}


