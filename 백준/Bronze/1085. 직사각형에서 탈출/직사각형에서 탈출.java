import java.io.*;
import java.util.Arrays;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
     */

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {

    }
    static void solve() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = input[0];
        int y = input[1];
        int w = input[2];
        int h = input[3];

        int xMin = (Math.abs(x - w) > Math.abs(x)) ? x : Math.abs((x - w));
        int yMin = (Math.abs(y - h) > Math.abs(y)) ? y : Math.abs((y - h));

        int anwer = Math.min(xMin, yMin);
        System.out.println(anwer);

    }
}