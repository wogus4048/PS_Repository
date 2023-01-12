
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<Integer> a = new HashSet<>();
    static Set<Integer> b = new HashSet<>();
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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

    }
    static void solve() throws IOException {
        int aMinusb = a.size();
        int bMinusa = b.size();

        for (int bNumbers : b) {
            if (a.contains(bNumbers)) {
                aMinusb--;
            }
        }
        for (int aNumbers : a) {
            if (b.contains(aNumbers)) {
                bMinusa--;
            }
        }
        bw.write(aMinusb+bMinusa+"");

    }
}