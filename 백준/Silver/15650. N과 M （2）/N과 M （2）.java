import java.io.*;
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
        combi(n,m,0,visited);



        bw.flush();
        bw.close();

    }

    public static void combi(int n, int r,int start,boolean[] visited) throws IOException{
        if (r == 0) {
            print(visited);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combi(n, r - 1,i+1 ,visited);
            visited[i] = false;
        }
    }

    public static void print (boolean[] visited) throws IOException {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                bw.write(i+1+" ");
            }
        }
        bw.newLine();
    }
}