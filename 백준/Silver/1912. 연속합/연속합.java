import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int[] dp ;
    static int[] numbers;
    static int max;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        String[] input = br.readLine().split(" ");
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        max = numbers[0]; //초기 최대값은 첫번째 숫자.
        dp[0] = numbers[0]; //인덱스0까지 최대값은 첫번째 숫자.

        getMax(n);
        bw.write(max + "");


        bw.flush();
        bw.close();

    }

    public static void getMax(int n) {
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(numbers[i], dp[i - 1] + numbers[i]);
            max = Math.max(max, dp[i]);
        }
    }

}