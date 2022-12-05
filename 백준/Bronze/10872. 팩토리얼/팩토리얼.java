import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int sum =1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        bw.write(sum+"");
        
        bw.flush();
        bw.close();

    }


}