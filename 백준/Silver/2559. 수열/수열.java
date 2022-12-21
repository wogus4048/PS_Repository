import java.io.*;
import java.util.Arrays;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
     */
    static int n;
    static int k;
    static int[] dp;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        dp = new int[n];
    }

    static void solve() throws IOException {
        memoization();

        //온도 최대값 구하기
        for (int i = k - 1; i < n; i++) {
            if (i - k < 0) {
                int temper = dp[i];
                max = Math.max(max, temper);
            } else {
                int temper = dp[i] - dp[i - k];
                max = Math.max(max, temper);
            }

        }
        bw.write(max+"");



    }

    static void memoization() throws  IOException{
        //dp 배열 채우기 -> 누적합 채우기
        String[] input = br.readLine().split(" ");
        dp[0] = Integer.parseInt(input[0]);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(input[i]);
        }
    }

}