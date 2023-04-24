

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

    /*
    * 바닷물을 bfs돌려서 빙산들을 1씩 감소시킨다.
    * 그 후 빙산을 bfs 돌려서 빙산의 덩어리 갯수를 센다.
    *
    * while문에서 bfs를 반복,
    * */

    static String[][] map;
    static boolean[][] visited;
    static int n,m;

    static int day=0;
    static int ice =0;

    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n][m];
        map = new String[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }


    }
    static void solve() throws IOException {

        ice = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //빙산갯수 측정
                if (Integer.parseInt(map[i][j]) > 0 && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }

        if (ice == 0) {
            System.out.println(0);
            System.exit(0);
        }

        while (true) {

            map = meltIce();
            day++;

            ice = 0;
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //빙산갯수 측정
                    if (Integer.parseInt(map[i][j]) > 0 && !visited[i][j]) {
                        bfs(i,j);
                    }
                }
            }

            if (ice == 0) {
                System.out.println(0);
                break;
            }
            if (ice >= 2) {
                System.out.println(day);
                break;
            }

        }

    }

    static String[][] meltIce() {
        //바닷물 적용
        String[][] temp = new String[n][m];


        for (int i = 0; i < n; i++) { //배열 복사
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(map[i][j]) > 0) { //빙산이라면
                    //주변의 바닷물 칸 갯수를 구한다.
                    int currentIceHeight = Integer.parseInt(map[i][j]);
                    int count = 0 ;
                    for (int a = 0; a < 4; a++) {
                        int nextI = i + di[a];
                        int nextJ = j + dj[a];

                        if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m) { //범위에 벗어나지 않고
                            if (map[nextI][nextJ].equals("0")) { // 바닷물이라면
                                count++;
                            }
                        }

                        if (currentIceHeight - count < 0) {
                            temp[i][j] = "0";
                        } else {
                            temp[i][j] = currentIceHeight - count + "";
                        }

                    }
                }
            }
        }
        return temp;

    }

    static void bfs(int i,int j) {
        //빙산이 몇덩어리인지 체크 -> bfs

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        ice++; // 얼음덩어리 갯수 증가.

        while (!q.isEmpty()) {

            int[] current = q.poll();
            int currentI = current[0];
            int currentJ = current[1];

            for (int a = 0; a < 4; a++) {
                int nextI = currentI + di[a];
                int nextJ = currentJ + dj[a];

                if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m) {
                    if (Integer.parseInt(map[nextI][nextJ]) > 0 && !visited[nextI][nextJ]) {
                        visited[nextI][nextJ] = true;
                        q.add(new int[]{nextI, nextJ});
                    }
                }
            }
        }
    }







}


