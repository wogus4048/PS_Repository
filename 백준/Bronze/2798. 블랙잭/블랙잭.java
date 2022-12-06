import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int max =0;
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
            for (int j = i+1; j < n; j++) {
                sum += numbers[j];
                for (int k = j+1; k < n; k++) {
                    sum += numbers[k];
                    if (sum > max && sum <= m) {
                        max = sum;
                    }
                    sum -= numbers[k];
                }
                sum -= numbers[j];
            }
            sum -= numbers[i];
        }

        bw.write(max+"");


        bw.flush();
        bw.close();

    }

}