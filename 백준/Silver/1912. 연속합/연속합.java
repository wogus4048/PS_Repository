import java.io.*;
import java.util.Arrays;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[] dp = new Integer[100001];
    static int[] array;
    static int n;
    static int max;
    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        array = new int[n + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(input[i - 1]);
        }
        max = array[1];

    }
    static void solve() throws IOException {
        dp[1] = array[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(dp[i], max);
        }
        bw.write(max + "");

    }

}