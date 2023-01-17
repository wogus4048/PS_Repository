import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<Integer, Integer> xMap = new HashMap<>();
    static Map<Integer, Integer> yMap = new HashMap<>();

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
        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            if (input[0] == 0 && input[1] == 0 && input[2] == 0) {
                break;
            }
            Arrays.sort(input);

            if (Math.pow((double) input[0], 2.0) + Math.pow((double) input[1], 2.0) == Math.pow(
                (double) input[2], 2.0)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }


    }
}