import java.io.*;
import java.math.BigInteger;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


   static int n;
   static int k;
    static int[] factoArray;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
//        factoArray = new int[n+1];
//
//        int nFac = facto(n);
//        int rFac = facto(k);
//        int nMinusRfac = facto(n - k);
//        int result = nFac / (nMinusRfac * rFac);
//        bw.write(result % 10007 + "");

        BigInteger nFac = facto(BigInteger.valueOf(n));
        BigInteger rFac = facto(BigInteger.valueOf(k));
        BigInteger nMinusRfac = facto(BigInteger.valueOf(n-k));

        BigInteger result = nFac.divide(nMinusRfac.multiply(rFac))
            .remainder(new BigInteger("10007"));

        bw.write(result.toString());

        bw.flush();
        bw.close();

    }

    public static BigInteger facto(BigInteger n) { //메모이제이션을 이용한 팩토리얼 구하기
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n.intValue(); i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;

    }

}