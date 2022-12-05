import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        bw.write(fibo(n) + "\n");
        
        bw.flush();
        bw.close();

    }
    static int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if ( n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);

    }


}