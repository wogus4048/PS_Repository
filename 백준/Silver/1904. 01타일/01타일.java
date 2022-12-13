import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //n=1 -> 1
    //n=2 -> 2
    //n=3 -> 3
    //n=4 -> 5
    //n=5 -> 8
    //n=6 -> 13
    //피보나치 이용

    static int[] result = new int[1000001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        bw.write(fibo(n)+"");
        bw.flush();
        bw.close();

    }

    public static int fibo(int n) {
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            result[i] = (result[i - 1] + result[i - 2])%15746;
        }
        return result[n];
    }



}