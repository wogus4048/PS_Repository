import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int result=0;

    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        boolean[] visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        combination(n, m, 0, 0, numbers,visited);
        bw.write(result+"");

        bw.flush();
        bw.close();

    }

    public static void combination(int n, int m,int count,int sum,int[] numbers,boolean[] visitied) {
        if (count == 3) {
            if (m >= sum && sum > result) {
                result = sum;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visitied[i])
            {
                visitied[i] = true;
                combination(n, m, count+1, sum + numbers[i], numbers, visitied);
                visitied[i] = false;
            }
        }

    }
    
}