import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int r, c;
  static char[][] map;
  static boolean[][] visited;
  static Queue<int[]> q = new LinkedList<>();
  static int[] start, target;

  public static void main(String[] args) throws IOException {
    input();
    solve();
    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    map = new char[r][c];
    visited = new boolean[r][c];
    start = new int[2];
    target = new int[2];

    for (int i = 0; i < r; i++) {
      String temp = br.readLine();
      for (int j = 0; j < c; j++) {
        char temp2 = temp.charAt(j);
        map[i][j] = temp2;

        if (temp2 == '*') {
          q.add(new int[] { i, j, -1, -1 }); // 물의 좌표 , 물이라는 표시 -1 , 물이므로 스텝은 -1
          visited[i][j] = true; // 물의 시작지점도 방문체크
        } else if (temp2 == 'D') {
          target = new int[] { i, j };
        } else if (temp2 == 'S') {
          start = new int[] { i, j };
        }
      }
    }
    // 고슴도치의 위치는 마지막에 큐에 추가
    q.add(new int[] { start[0], start[1], 0, 0 });// 고슴도치 좌표 ,고슴도치라는 표시 0 , 스텝은 0부터\
    visited[start[0]][start[1]] = true; // 고슴도치 시작지점은 방문체크

    // for (char[] a : map) {
    // bw.write(Arrays.toString(a) + "\n");
    // }
  }

  public static void solve() throws IOException {

    int result = bfs();
    if (result == -1) {
      bw.write("KAKTUS" + "");
    } else {
      bw.write(result + "\n");
    }

  }

  public static int bfs() throws IOException {
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    while (!q.isEmpty()) {
      int[] current = q.poll();
      int current_x = current[0];
      int current_y = current[1];
      int current_who = current[2];
      int current_step = current[3];

      if (current_x == target[0] && current_y == target[1]) {
        return current_step;
      }

      for (int i = 0; i < 4; i++) {
        int next_x = current_x + dx[i];
        int next_y = current_y + dy[i];

        if (next_x >= 0 && next_x < r && next_y >= 0 && next_y < c) {
          // 범위를 벗어나지않아야하고
          // 돌인지 체크
          if (map[next_x][next_y] != 'X') // 돌이 아니여야함
          {
            if (!visited[next_x][next_y])// 방문한곳인지 체크
            {
              if (map[next_x][next_y] == 'D')// 도착지점이라면
              {
                if (current_who == 0) {
                  // 고슴도치일때만 큐에넣는다.
                  q.add(new int[] { next_x, next_y, 0, current_step + 1 });
                  visited[next_x][next_y] = true;
                }
              } else {
                // 도착지점이 아니고 물이라면
                if (current_who == -1) {
                  q.add(new int[] { next_x, next_y, -1, current_step });
                  visited[next_x][next_y] = true;
                }
                // 도착지점이 아니고 고슴도치면
                if (current_who == 0) {
                  q.add(new int[] { next_x, next_y, 0, current_step + 1 });
                  visited[next_x][next_y] = true;
                }
              }
            }
          }

        }

      }

    }
    return -1;

  }

}