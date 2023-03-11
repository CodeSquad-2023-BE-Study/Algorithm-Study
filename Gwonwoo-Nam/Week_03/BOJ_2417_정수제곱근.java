import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_2417_정수제곱근 {
    public static void main(String[] args) throws IOException {
        long mid= 0;
        long low = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long key = Long.parseLong(br.readLine());
        long high = key;
        if (key == 0) {
            System.out.println(0);
            return ;
        }
        else if (key == 1) {
            System.out.println(1);
            return ;
        }

        while (low + 1 < high) {
            mid = (low + high) / (long)2;

            if (check(mid, key)) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        System.out.println(high);
    }

    public static boolean check(long number, long key) {
        BigInteger bigInteger = new BigInteger(String.valueOf(number));
        BigInteger result = bigInteger.multiply(bigInteger);
        //OVERFLOW 발생 방지
        if (result.compareTo(new BigInteger(String.valueOf(Long.MAX_VALUE))) == 1) {
            return false;
        }
        return result.longValue() < key;
    }
}
