import java.io.*;
import java.util.Arrays;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*

     */

    static int n;
    static int[][] paper  ;
    static int result1=0;
    static int result0=0;
    static int resultMinus=0;

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            paper[i] = input;
        }


    }

    static void solve() throws IOException {
        dividePaper(0, 0, n);
        bw.write(resultMinus+"\n"+result0+"\n"+result1);

    }

    static void dividePaper (int x, int y ,int n)throws IOException {
        if (checkPaper(x, y, n)) {
            int firstNumber = paper[x][y];
            if (firstNumber == 1) {
                result1++;
            } else if (firstNumber == 0) {
                result0++;
            } else {
                resultMinus++;
            }
            return;
        }

        //왼쪽 맨위부터   [x가 i 인덱스이므로 -> 행 (가로) , y가 j 인덱스이므로 -> 열(세로)]
        dividePaper(x, y, n / 3); // 1번
        dividePaper(x, y+(n/3), n / 3); // 2번
        dividePaper(x, y+(2*n/3), n / 3); // 3번
        dividePaper(x+(n/3), y, n / 3); // 4번
        dividePaper(x+(n/3), y+(n/3), n / 3); // 5번
        dividePaper(x+(n/3), y+(2*n/3), n / 3); // 6번
        dividePaper(x+(2*n/3), y, n / 3); // 7번
        dividePaper(x+(2*n/3), y+(n/3), n / 3); // 8번
        dividePaper(x+(2*n/3), y+(2*n/3), n / 3); // 9번

    }

    static boolean checkPaper (int x, int y , int n) throws IOException {
        int startNumber = paper[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] != startNumber) {
                    return false;
                }
            }
        }
        return true;
    }
    
}