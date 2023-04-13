

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n,m,k;

    static int[][] map;
    static int count=0;
    static List<Integer> result = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int testcase;

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
        for (int b = 0; b < testcase; b++) {
            count =0;
            String[] info = br.readLine().split(" ");
            n = Integer.parseInt(info[0]);
            m = Integer.parseInt(info[1]);
            k = Integer.parseInt(info[2]);


            map = new int[n][m];

            for (int a = 0; a < k; a++) {
                String[] input = br.readLine().split(" ");
                map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        bfs(new Node(i, j));
//                    dfs(i,j);
//                        result.add(count);

                    }
                }
            }
//            bw.write(result.size() + "\n");
//            result.sort(Comparator.naturalOrder());
//            for (int a : result) {
//                bw.write(a+"\n");
//            }
            bw.write(count+"\n");
        }




    }

    static void dfs(int i, int j) {
        count++;

        for (int a = 0; a < 4; a++) {
            int nextI = i + dy[a];
            int nextJ = j + dx[a];

            if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n) {
                if (map[nextI][nextJ] == 1) {
                    map[nextI][nextJ] = 0;
//                    System.out.print("nextJ = " + nextJ);
//                    System.out.println("  nextI = " + nextI);
//                    System.out.println("count = " + count);
                    dfs(nextI, nextJ);
                }
            }
        }

    }
    static void bfs(Node node) {
        count++;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map[node.i][node.j] = 0;

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            int currentI = currentNode.i;
            int currentJ = currentNode.j;

            for (int i = 0; i < 4; i++) {
                int nextI = currentI + dy[i];
                int nextJ = currentJ + dx[i];

                if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m) {
                    if (map[nextI][nextJ] == 1) {
                        map[nextI][nextJ] = 0;
                        q.add(new Node(nextI, nextJ));
                    }
                }
            }
        }

    }

    static class Node{
        int i;
        int j;

        public Node(int i,int j){
            this.i = i;
            this.j = j;
        }
    }

}


