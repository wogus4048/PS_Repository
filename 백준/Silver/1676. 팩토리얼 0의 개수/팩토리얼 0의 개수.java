import java.io.*;
import java.math.BigInteger;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int zeroCount =0;
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        while (true) {
            BigInteger num = result.remainder(BigInteger.valueOf(10));
            if (num.toString().equals("0")) {
                zeroCount++;
                result = result.divide(BigInteger.valueOf(10));
            }
            else{
                break;
            }
        }


        bw.write(zeroCount+"");

        bw.flush();
        bw.close();

    }

}