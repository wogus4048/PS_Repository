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
        int[] result = new int[m];

        permu(n,m,0,visited,result);


        bw.flush();
        bw.close();

    }

    public static void permu(int n, int r,int count, boolean[] visited,int[] result)throws IOException {
        if (count == r) {
            for (int currentNum : result) {
                bw.write(currentNum+" ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i])
            {
                visited[i] = true;
                result[count] = i+1;
                permu(n, r, count + 1, visited,result);
                visited[i] = false;
            }
        }

    }



}
