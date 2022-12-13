import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        boolean[] visited = new boolean[n];
        int[] result = new int[m];
        combi(n,m,0,visited,result,0);



        bw.flush();
        bw.close();

    }

    public static void combi(int n, int r,int start,boolean[] visited,int[] result,int depth) throws IOException{
        if (r == depth) {
            for (int i = 0; i < r; i++) {
                bw.write(result[i]+" ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (depth != 0 && result[depth - 1] > i + 1) {
                continue;
            }
            visited[i] = true;
            result[depth] = i+1;
            combi(n, r,i+1 ,visited,result,depth+1);
            visited[i] = false;
        }
    }

}