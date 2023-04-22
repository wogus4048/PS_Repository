

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dh = {0,0,0,0,1,-1};
    static int[] di = {1,-1,0,0,0,0};
    static int[] dj = {0,0,1,-1,0,0};


    /*
    * 3차원 배열을 이용해서 bfs 풀이
    * 입력받을때 0의갯수를 체크, 0의 갯수가 0이면 0출력하고 종료
    * 마지막에도 0의갯수를 체크, 0의 갯수가 존재하면 -1 출력하고 종료
    * */

    static String[][][] map;
    static boolean[][][] visited;
    static int n,m,h;

    static int result = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        String[] info = br.readLine().split(" ");
        m = Integer.parseInt(info[0]);
        n = Integer.parseInt(info[1]);
        h = Integer.parseInt(info[2]);

        map = new String[h][n][m];
        visited = new boolean[h][n][m];


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = br.readLine().split(" ");
            }
        }

        int zeroCount = checkZeroCount();
        if (zeroCount == 0) {
            bw.write(0+"");
            bw.close();
            System.exit(0);

        }

//        System.out.println(Arrays.deepToString(map));

    }
    static void solve() throws IOException {
        bfs();
        int zeroCount = checkZeroCount();
        if (zeroCount != 0) {
            bw.write(-1+"");
            return;
        }
        else{
            bw.write(result+"");
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k].equals("1")) {
                        q.add(new int[]{i, j, k, 0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentH = current[0];
            int currentI = current[1];
            int currentJ = current[2];
            int currentDay = current[3];

            result = Math.max(result, currentDay);

            for (int i = 0; i < 6; i++) {
                int nextH = currentH + dh[i];
                int nextI = currentI + di[i];
                int nextJ = currentJ + dj[i];

                if (nextH >= 0 && nextH < h && nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m) {
                    if (map[nextH][nextI][nextJ].equals("0") && !visited[nextH][nextI][nextJ]) {
                        map[nextH][nextI][nextJ] = "1";
                        visited[nextH][nextI][nextJ] = true;
                        q.add(new int[]{nextH, nextI, nextJ, currentDay + 1});
                    }
                }
            }

        }







    }
    static int checkZeroCount() {
        int count =0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k].equals("0")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }




}


