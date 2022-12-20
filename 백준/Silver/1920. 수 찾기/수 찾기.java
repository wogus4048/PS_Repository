import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    완전탐색으로 풀려고하면 10만 * 10만으로 시간초과가 발생할것이 뻔하였다.
    Map을 이용하여 containsKey를 사용하면 O(1)로 시간안에 풀수있지않을까.

     */
    static int n;
    static int m;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        String[] nInput = br.readLine().split(" ");
        for (int i=0;i<n;i++) {
            map.put(nInput[i], i);
        }

    }

    static void solve() throws IOException {
        m = Integer.parseInt(br.readLine());
        String[] mInput = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            String currentNumber = mInput[i];
            if (map.containsKey(currentNumber)) {
                bw.write(1 + "\n");
            } else {
                bw.write(0+"\n");
            }
        }

    }

}