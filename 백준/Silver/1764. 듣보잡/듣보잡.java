import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<String> names = new HashSet<>();
    static List<String> answer = new ArrayList<>();
    static int n,m;
    /*
     */

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            names.add(name);
        }

    }
    static void solve() throws IOException {
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (names.contains(name)) {
                answer.add(name);
            }
        }
        bw.write(answer.size() + "\n");
        answer.sort(Comparator.naturalOrder());
        for (String name : answer) {
            bw.write(name+"\n");
        }

    }
}