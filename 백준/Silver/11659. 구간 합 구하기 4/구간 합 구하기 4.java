import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    단순하게 반복문을 이용하여 풀려고해서 시간초과 -> n,m의 최대값이 10만이라는것을 못보았다. 이중반복문으로 처리시 100억의 연산횟수가 발생하므로 시간초과
    연산수를 줄이기 위해서는 다이나믹프로그래밍을 이용한다.
    dp배열에는 해당 인덱스까지의 숫자 총합을 넣어주고
    인덱스 4~6의 총합을 구하려면 dp[6] - dp[3] 값을 해줘서 1~6인덱스 숫자들의 합에서 1~3인덱스 숫자들의 합을 뺴준다.
     */

    static int n;
    static int m;
    static int[] numbers;
    static int[] dp;


    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        numbers = new int[n];
        dp = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

    }

    static void solve() throws IOException {
        bottomUp();
        for (int a = 0; a < m; a++) {
            String[] input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0])-2;
            int j = Integer.parseInt(input[1])-1;
            if (i < 0) {
                bw.write(dp[j]+"\n");
            }
            else{
                bw.write((dp[j]-dp[i]) +"\n");
            }
        }

    }
    static void bottomUp() throws IOException {
        dp[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + numbers[i];
        }
    }


}