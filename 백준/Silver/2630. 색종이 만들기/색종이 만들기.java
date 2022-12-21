import java.io.*;
import java.util.Arrays;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    현재 네모칸이 모두 1(파란색) 인지 0(흰색)인지 체크하고 아니면 가로세로를 반반나눠서 다시 체크한다.
    모두 1 또는 0이라면 어떤 색종이인지 체크.
     */
    static int[][] map;
    static int blue;
    static int white;
    static int size;


    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                map[i][j] = input[j];
            }
        }
    }

    static void solve() throws IOException {

        checkColor(0, 0,size);
        bw.write(white+"\n"+blue);
    }
    static void checkColor(int x, int y,int n) throws IOException {
        int color = map[x][y];
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (map[i][j] != color) {
                    checkColor(x, y, n/2); //왼쪽 위
                    checkColor(x + (n / 2), y ,n/2); //오른쪽위
                    checkColor(x , y + (n / 2),n/2); //왼쪽아래
                    checkColor(x + (n / 2), y + (n / 2),n/2); //오른쪽아래
                    return;
                }
            }
        }

        if (color == 1) {
            blue++;
        } else {
            white++;
        }
    }


}