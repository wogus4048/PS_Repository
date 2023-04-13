import java.io.*;
import java.util.Arrays;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int testcase;
    static int[] dp = new int[41];
    static int count1 =0;
    static int count2 =0;

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        int n = Integer.parseInt(br.readLine());
        fibo1(n);
        fibo2(n);
        bw.write(count1 + " " + count2);


    }
    static void solve() throws IOException {

    }

    static int fibo1(int n )
    {
        if(n==1 || n==2)
        {
            count1++;
            return 1;
        }
        return fibo1(n - 1) + fibo1(n - 2);
    }

    static int fibo2(int n) {
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            count2++;
        }
        return dp[n];
    }

}