import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstRing = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            int nextRing = Integer.parseInt(st.nextToken());
            int gcd = gcd(firstRing, nextRing);
            bw.write(firstRing/gcd+"/"+nextRing/gcd+"\n");
        }



        bw.flush();
        bw.close();

    }

    //최대공약수
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}