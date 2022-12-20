import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    조합(dfs + 백트래킹)의 시간복잡도는 O(2^n)이다. 중복조합도 비슷하지않을까?
    뽑는 리스트가 10개 이니까 진행해보자. -> 조합으로 풀려니 n개중 몇개를 뽑는 r에대해 넣을수없음
    필요한 동전갯수가 최소갯수려면 가장 큰 동전을 많으쓰면 되니까, 가장 큰 동전으로 나눠지는 몫을 더하고 ,안나눠지면 그 다음으로 큰동전...을 반복하자
     */

    static int n;
    static int k;
    static int[] coins;

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
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            int currentCoin = Integer.parseInt(br.readLine());
            coins[i] = currentCoin;
        }
    }

    static void solve() throws IOException {

        int count =0;

        for (int i = n-1; i >= 0; i--) {
            if (k == 0) {
                break;
            }
            if ((k / coins[i]) > 0) { //나눠지면
                count += k / coins[i]; //동전갯수 더하고
                k = k - (coins[i] * (k / coins[i]));
            }
        }
        bw.write(count+"");


    }




}