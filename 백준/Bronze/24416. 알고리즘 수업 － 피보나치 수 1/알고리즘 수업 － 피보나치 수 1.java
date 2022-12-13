import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] fiboStore = new int[41];
    static int fibo1Count;
    static int fibo2Count;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        fibo1(n);
        fibo2(n);

        bw.write(fibo1Count + " " + fibo2Count);
        bw.flush();
        bw.close();

    }

    public static int fibo1(int n) { //재귀
        if (n == 1 || n == 2) {
            fibo1Count++;
            return 1;
        }
        return fibo1(n - 1) + fibo1(n - 2);
    }

    public static int fibo2(int n) {
        fiboStore[1] = 1;
        fiboStore[2] = 1;
        for (int i = 3; i <= n; i++) {
            fiboStore[i] = fiboStore[i - 1] + fiboStore[i - 2];
            fibo2Count++;
        }
        return fiboStore[n];
    }


}