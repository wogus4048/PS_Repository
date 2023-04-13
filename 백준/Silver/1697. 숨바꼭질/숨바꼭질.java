

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n,k;
    static boolean[] visited = new boolean[100001];


    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);


    }
    static void solve() throws IOException {

        bfs();

    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] current= q.poll();
            int currentPosition = current[0];
            int currentTime = current[1];

            if (currentPosition == k) {
                System.out.println(currentTime);
                return;
            }

            int nextPosition = currentPosition * 2;
            if (nextPosition <= 100000 && nextPosition >= 0) {
                if(!visited[nextPosition])
                {
                    visited[nextPosition] = true;
                    q.add(new int[]{nextPosition, currentTime + 1});
                }
            }

            nextPosition = currentPosition - 1;
            if (nextPosition <= 100000 && nextPosition >= 0) {
                if(!visited[nextPosition])
                {
                    visited[nextPosition] = true;
                    q.add(new int[]{nextPosition, currentTime + 1});
                }
            }

            nextPosition = currentPosition + 1;
            if (nextPosition <= 100000 && nextPosition >= 0) {
                if(!visited[nextPosition])
                {
                    visited[nextPosition] = true;
                    q.add(new int[]{nextPosition, currentTime + 1});
                }
            }
        }

    }




}


