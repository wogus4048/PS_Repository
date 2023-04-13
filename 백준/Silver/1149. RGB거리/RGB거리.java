

import java.io.*;
import java.util.Arrays;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[] dp = new Integer[1001];
    static int[][] array;
    static int n;
    static int min;
    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        array = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(input[j]);
            }
        }


    }
    static void solve() throws IOException {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    array[i][j] = Math.min(array[i-1][1], array[i-1][2]) + array[i][j];

                } else if (j == 1) {
                    array[i][j] = Math.min(array[i-1][0], array[i-1][2]) + array[i][j];
                } else {
                    array[i][j] = Math.min(array[i-1][1], array[i-1][0]) + array[i][j];
                }

            }

        }
//        System.out.println(Arrays.deepToString(array));

        min = array[n-1][0];
        for (int i = 1; i < 3; i++) {
            min = Math.min(min, array[n-1][i]);
        }
        System.out.println(min);
    }




}


