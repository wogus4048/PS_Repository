import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    조합의 동작방식 느낌인데, 이전것만 아니면 골랐던거를 다시골라도 되는 조합이다. 집의수가 1000개까지 있으니 O(2^1000)은 시간초과를 할것이다.
    dp배열을 어떻게 구성할것인지, 어떤 로직인지 생각하는게 중요한거같다.
    dp배열에는 현재 집의 해당 인덱스의 색을 선택했을경우 비용의 최솟값을 저장해준다.
    2번째 집에서 레드칸에 들어갈 최솟값은   그린(1번집)+레드(2번집) 의 겅우와 블루(1번집)+레드(2번집)의 비용합중 더 작은값을 적으면 될것이다.
    그렇게 n번째 집까지의 각 색깔별 비용최소값을 적고 마지막에 n번째줄의 3가지 색중 최소값을 출력해준다.
     */

    static int n;
    static int[][] cost;
    static int[][] dp;


    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(input[0]);
            cost[i][1] = Integer.parseInt(input[1]);
            cost[i][2] = Integer.parseInt(input[2]);
        }
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

    }

    static void solve() throws IOException {
        //바텀업 방식으로 dp배열을 채운다.

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) { //레드일때 ,  (이전집 블루비용 + 현재집 레드비용) vs(이전집 그린비용 + 현재집 레드비용) 중 최소값을 저장
                    dp[i][0] = Math.min(dp[i - 1][1] + cost[i][0], dp[i - 1][2] + cost[i][0]);
                }
                if (j == 1) {
                    dp[i][1] = Math.min(dp[i - 1][0] + cost[i][1], dp[i - 1][2] + cost[i][1]);
                }
                if (j == 2) {
                    dp[i][2] = Math.min(dp[i - 1][0] + cost[i][2], dp[i - 1][1] + cost[i][2]);
                }
            }
        }

        bw.write(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2])+"");


    }


}