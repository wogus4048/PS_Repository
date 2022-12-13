import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int result;


    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        boolean[] visited = new boolean[n];
        if (k == 0) {
            bw.write(1+"");
        }
        else{
            combi2(k,0,0,n);
            bw.write(result+"");

        }




        bw.flush();
        bw.close();

    }

    //조합
    public static void combi(int target, int count,int start, boolean[] visited) {
        if (count == target) {
            result++;
            return;
        }
        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(target, count + 1,i+1, visited);
                visited[i] = false;
            }
        }

    }
    public static void combi2(int target, int count,int start,int n) {
        if (count == target) {
            result++;
            return;
        }
        for (int i = start; i < n; i++) {
            combi2(target, count + 1,i+1,n);
        }

    }


}