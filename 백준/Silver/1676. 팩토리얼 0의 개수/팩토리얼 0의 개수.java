import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();
    }

    static void input() throws IOException {

    }

    static void solve() throws IOException {
        //팩토리얼 계산기 만들고, 값 저장하고, 뒤에서부터 0이 아닌거 나올때까지 0을 센다.

        int n = Integer.parseInt(br.readLine());

        BigInteger result = new BigInteger("1");


        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }


        char[] arr = result.toString().toCharArray();

        int count =0;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] == '0') {
                count++;
            }
            else{
                break;
            }
        }
        System.out.println(count);

    }


}
