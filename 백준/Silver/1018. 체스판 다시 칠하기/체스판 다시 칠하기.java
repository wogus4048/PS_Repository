import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); //열
        int m = Integer.parseInt(input[1]); //행

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                int paint = paintCount(n, m, i, j, board);
                if (min > paint) {
                    min = paint;
                }
            }
        }

        bw.write(min+"");

        bw.flush();
        bw.close();

    }

    public static int paintCount(int n,int m,int currentX, int currentY,char[][] board) {
        int count =0;
        char color = board[currentX][currentY];

        for (int i = currentX; i < currentX+8; i++) {
            for (int j = currentY; j < currentY+8; j++) {
                if (board[i][j] != color) {
                    count++;
                }
                if (color == 'W') {
                    color = 'B';
                }
                else{
                    color = 'W';
                }
            }
            if (color == 'W') {
                color = 'B';
            }
            else{
                color = 'W';
            }
        }
        count = Math.min(count, 64 - count);

        return count;

    }


}