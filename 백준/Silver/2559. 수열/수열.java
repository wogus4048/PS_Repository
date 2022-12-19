import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    다이나믹 프로그래밍을 이용한 연속합문제에서 몇개를 연속해서 더할지를 알려준 문제같다고 생각했지만
    다들 이중반복문으로 풀이했다.
    그냥 n,k의 최댓값인 10만떄문에 연산횟수가 10만 *10만일거라고 생각했다.
    하지만 (n-k) * k 만큼의 연산이므로 최대연산수는 대략 10만회정도이다.
    문제풀기전 어떤 로직으로 해야할지, 그 로직의 최악의 연산횟수는 어떻게 될지 제대로 생각해야겠다.
     */

    static int n;
    static int k;
    static int[] numbers;
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
        numbers = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

    }

    static void solve() throws IOException {
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i+k; j++) {
                sum += numbers[j];
            }
            max = Math.max(max, sum);
        }
        bw.write(max+"");

    }


}