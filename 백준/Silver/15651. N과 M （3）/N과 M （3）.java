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

//        combi(n, m, 0, 0, new boolean[n]);
        permu(n,m, 0, new int[m]);

    }

    static void solve() throws IOException {




    }

    static void permu(int n, int r, int depth,int[] result) throws IOException {
        if (r == depth) {
            for (int i : result) {
                bw.write(i+" ");
            }
            bw.newLine();
            return; 
        }

        for (int i = 0; i < n; i++) {
            result[depth] = i+1;
            permu(n, r, depth + 1, result);
        }
    }


    static void combi(int n, int r, int depth, int index, boolean[] visited) {
        if (depth == r) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(i + 1+" ");
                }
            }
            System.out.println();
        }

        for (int i = index; i < n; i++) {
            visited[i] = true;
            combi(n, r, depth + 1, i + 1, visited);
            visited[i] = false;
        }

    }


}
