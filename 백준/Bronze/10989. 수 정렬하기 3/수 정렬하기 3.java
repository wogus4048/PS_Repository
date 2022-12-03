import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] numberArray = new int[n];

        for (int i = 0; i < n; i++) {
            numberArray[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numberArray);

        for (int i = 0; i < n; i++) {
            bw.write(numberArray[i] + "\n");
        }


        bw.flush();
        bw.close();
    }
}