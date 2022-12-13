import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //새게 중 하나라도 0보다 같거나 작으면 1
    //3개중 하나라도 20보다 크면 w(20,20,20)값
    //a b c가 서로같지않고 오름차순이라면 w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    // 그외 w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

    static int[][][] wResult = new int[22][22][22];  // 0 ~ 21


    public static void main(String[] args) throws IOException {

        while (true) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("-1") && input[1].equals("-1") && input[2].equals("-1") ){
                break;
            }
            int result = w(Integer.parseInt(input[0]) , Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            bw.write(String.format("w(%s, %s, %s) = %d",input[0],input[1],input[2],result));
            bw.newLine();

        }
        bw.flush();
        bw.close();

    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            if (wResult[20][20][20] > 0) {
                return wResult[20][20][20];
            }
            wResult[20][20][20] = w(20, 20, 20);
            return wResult[20][20][20];
        }
        if (a < b && b < c) {
            if (wResult[a][b][c] > 0) {
                return wResult[a][b][c];
            }
            wResult[a][b][c] =
                w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return wResult[a][b][c];
        }
        else{
            if (wResult[a][b][c] > 0) {
                return wResult[a][b][c];
            }
            wResult[a][b][c] =
                w(a-1,b,c) + w(a - 1,b - 1,c) + w(a - 1,b,c - 1)
                    - w(a - 1,b - 1,c - 1);
            return wResult[a][b][c];
        }

    }


}