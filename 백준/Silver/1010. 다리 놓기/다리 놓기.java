import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] result = new int[31][31];


    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            boolean[] visited = new boolean[n];

            if (k == n) {
                bw.write(1+"\n");
            }
            else{
                bw.write(combi(k, n)+"\n");

            }
        }



        bw.flush();
        bw.close();

    }

    public static int combi(int n,int r) {
        if (result[n][r] > 0) {
            return result[n][r];
        }
        else if (n == r || r == 0) {
            result[n][r] = 1;
            return result[n][r];
        }
        else{
            result[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
            return result[n][r];
        }

    }


}