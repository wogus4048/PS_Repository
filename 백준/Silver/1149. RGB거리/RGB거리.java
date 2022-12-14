import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int Red = 0;
    static final int Green = 1;
    static final int Blue = 2;

    static int[][] dp ;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        cost = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            cost[i][Red] = Integer.parseInt(input[Red]);
            cost[i][Green] = Integer.parseInt(input[Green]);
            cost[i][Blue] = Integer.parseInt(input[Blue]);
        }

        dp[0][Red] = cost[0][Red];
        dp[0][Green] = cost[0][Green];
        dp[0][Blue] = cost[0][Blue];

        bw.write(Math.min(paintCost(n - 1, Red),
            Math.min(paintCost(n - 1, Green), paintCost(n - 1, Blue))) + "");


        bw.flush();
        bw.close();

    }

    static int paintCost(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == Red) {
                dp[n][Red] =
                    Math.min(paintCost(n - 1, Green), paintCost(n - 1, Blue)) + cost[n][Red];
            }
            else if (color == Green) {
                dp[n][Green] =
                    Math.min(paintCost(n - 1, Blue), paintCost(n - 1, Red)) + cost[n][Green];
            }
            else {
                dp[n][Blue] =
                    Math.min(paintCost(n - 1, Green), paintCost(n - 1, Red)) + cost[n][Blue];
            }

        }
        return dp[n][color];
    }

}