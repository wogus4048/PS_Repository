import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();
    }

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[] checked = new int[m];
        permutation(checked, 0, new boolean[n]);

    }

    static void solve() throws IOException {




    }

    static void permutation(int[] checked, int depth,boolean[] visited) throws IOException{
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : checked) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
            return;
        }

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                checked[depth] = i+1;
                permutation(checked, depth + 1,visited);
                visited[i] = false;
            }

        }


    }


}