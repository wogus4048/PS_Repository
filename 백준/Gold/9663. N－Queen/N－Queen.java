import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int result ;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] queenPosition = new int[n];
        boolean[][] atackRange = new boolean[n][n];

        dfs(n, atackRange, queenPosition, 0);
        bw.write(result+"");



        bw.flush();
        bw.close();

    }
    public static void dfs(int n,boolean[][] atackRange,int[] queenPosition,int i) throws IOException{
        if (i == n) { //마지막줄까지 이동했을때
//            for (int cu : queenPosition) {
//                bw.write(cu + " ");
//            }
//            bw.newLine();
            result ++;
            return;
        }

        for (int a = 0; a < n; a++) {
            if (!atackRange[i][a]) { //만약 공격범위가 아니라면
                queenPosition[i] = a; //해당 위치에 퀸을 놓고 , 퀸의 위치를 저장한다.

                //방금놓은 퀸의 공격범위를 추가
                atack(atackRange, i, a);

                dfs(n, atackRange, queenPosition, i + 1); // 공격범위업데이트,퀸 위치 추가 , 다음열로 이동 시켜서 dfs호출

                queenPosition[i] = -1; //퀸 위치 초기화 (이 자리에 안놓은 경우 생성)

                //공격범위 체크했던거 되돌려놓기
                cleanAtackRange(atackRange, queenPosition,i, a);

            }
        }
        // 다 돌았는데 퀸을 놓을 수 있는 자리가 없어서 퀸의 위치가 0이라면 (해당 열이 모두 공격범위라서 못놓았을때)
        if (queenPosition[i] == -1) {
            return; //더 보지않고 return
        }


    }





    public static void atack(boolean[][] atackRange,int i,int j)throws IOException {
        int n = atackRange.length; // 길이

        // 자기자신위치 , 왼쪽대각선아래, 아래, 오른쪽 대각선아래를 공격범위로 채워준다.
        atackRange[i][j] = true; //자기자신

        int nextI = i;
        int nextJ = j;
        //왼쪽 대각선 아래
        while (true) {
            nextI = nextI + 1;
            nextJ = nextJ - 1;
            if (nextI >= n || nextJ < 0) {
                break;
            }
            atackRange[nextI][nextJ] = true;
        }
        nextI = i;
        nextJ = j;
        //오른쪽 대각선 아래
        while (true) {
            nextI = nextI + 1;
            nextJ = nextJ + 1;
            if (nextI >= n || nextJ >= n) {
                break;
            }
            atackRange[nextI][nextJ] = true;
        }
        nextI = i;
        nextJ = j;
        //아래
        while (true) {
            nextI = nextI + 1;
            if (nextI >= n) {
                break;
            }
            atackRange[nextI][j] = true;
        }
    }
    public static void cleanAtackRange(boolean[][] atackRange,int[] queenPosition,int i,int j) throws IOException{
        int n = atackRange.length;
        //전부 false로 초기화 시키고
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                atackRange[a][b] = false;
            }
        }
        // 이전 퀸 위치를 받아 다시 공격범위 설정
        for (int c = 0; c < n; c++) {
            if (queenPosition[c] != -1) { //-1로 초기화하기전 퀸 위치에 관하여 공격범위 설정
                atack(atackRange, c, queenPosition[c]);
            }
        }
    }



}