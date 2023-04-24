

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
    * 집 -> 페스티벌으로 맥주 몇개로 갈 수 있는지 체크
    * 한방에 못갈때 집 -> 편의점이 20개 이하이고, 편의점 -> 페스티벌이 20개 이하인 경우가 있는지 체크
    * map에 각 위치별 집에서 출발시 필요한 맥주갯수로 표시
    *
    * */

    static boolean[] visited;
    static int testcase,storeCount;
    static int[][] store;
    static int[] home,target;


    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        testcase = Integer.parseInt(br.readLine());
    }
    static void solve() throws IOException {

        for (int i = 0; i < testcase; i++) {

            //초기화
            storeCount = Integer.parseInt(br.readLine());
            home = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            store = new int[storeCount][2];
            for (int j = 0; j < storeCount; j++) {
                store[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            visited = new boolean[storeCount];

            String result = bfs() ? "happy" : "sad";
            System.out.println(result);

        }



    }

    static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(home);
        int targetI = target[0];
        int targetJ = target[1];
        int homeI = home[0];
        int homeJ = home[1];


        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentI = current[0];
            int currentJ = current[1];

            if (Math.abs(targetI - currentI) + Math.abs(targetJ - currentJ) <= 1000) {
                return true;
            }

            for (int i = 0; i < storeCount; i++) {
                if (!visited[i]) {
                    int storeI = store[i][0];
                    int storeJ = store[i][1];

                    if (Math.abs(storeI - currentI) + Math.abs(storeJ - currentJ) <= 1000) {
                        q.add(new int[]{storeI, storeJ});
                        visited[i] = true;
                    }
                }
            }
        }

        return false;

    }







}


