import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    Map에 숫자,갯수 를 저장해놓고 , ContainsKey를 이용하여 풀어본다.

     */
    static int n;
    static int m;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        String[] nInput = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(nInput[i]);
            map.put(currentNumber, map.getOrDefault(currentNumber, 0) + 1);
        }

    }

    static void solve() throws IOException {
        m = Integer.parseInt(br.readLine());
        String[] nInput = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if (map.get(Integer.parseInt(nInput[i])) != null) {
                bw.write(map.get(Integer.parseInt(nInput[i])) + " ");
            } else {
                bw.write(0+" ");
            }
        }

    }

}