import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            data[i][0] = Integer.parseInt(input[0]);
            data[i][1] = Integer.parseInt(input[1]);
        }

        int[] rating = new int[n];
        Arrays.fill(rating, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (data[i][0] < data[j][0] && data[i][1] < data[j][1]) {
                        rating[i] ++;
                    }
                }
            }
        }

        for (int rank : rating) {
            bw.write(rank+" ");
        }


        bw.flush();
        bw.close();

    }


}