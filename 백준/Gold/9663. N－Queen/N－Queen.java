import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, count;
  static boolean[][] attack_zone;
  static boolean[][] queen;

  public static void main(String[] args) throws IOException {
    input();
    solve();
    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    N = Integer.parseInt(br.readLine());
    count = 0;
    attack_zone = new boolean[N][N];
    queen = new boolean[N][N];

  }

  public static void solve() throws IOException {
    dfs(0);
    bw.write(count + "\n");
  }

  public static void dfs(int depth) throws IOException {
    int current_depth = depth;
    // for (boolean[] a : attack_zone) {
    // bw.write(Arrays.toString(a) + "\n");
    // }
    // bw.write("\n");
    if (current_depth == N) // N-1 까지 실행되서 N으로 넘어왔을때 count 증가 및 종료
    {
      count++;
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!attack_zone[depth][i]) {
        queen[depth][i] = true; // 퀸 위치 찍고

        attack_marking(i, depth); // 공격범위 체크해주고

        dfs(depth + 1); // dfs로 다음 depth로 이동

        queen[depth][i] = false;
        // dfs가 끝나 돌아왔다면 진행한 부분은 다시 원상태로 돌려놔야한다.
        init_attackzone();
      }
    }

  }

  public static void attack_marking(int position, int depth) throws IOException {
    // 해당 위치의 아래(+자기자리) 왼쪽 대각선 ,오른쪽 대각선을 공격존으로 표시해준다.
    for (int i = depth; i < N; i++) {// 퀸을 놓은 자리 + 그 아래쪽 공격존 표시
      attack_zone[i][position] = true;
    }

    int current_i = depth;
    int current_j = position;

    while (true) {
      current_i = current_i + 1;
      current_j = current_j - 1;

      if (current_i < N && current_j >= 0) {// 왼쪽아래로 갔을때 범위를 넘어가지않는지 체크
        attack_zone[current_i][current_j] = true;
      } else {
        break;
      }
    }

    current_i = depth;
    current_j = position;

    while (true) {
      current_i = current_i + 1;
      current_j = current_j + 1;

      if (current_i < N && current_j < N) {// 왼쪽아래로 갔을때 범위를 넘어가지않는지 체크
        attack_zone[current_i][current_j] = true;
      } else {
        break;
      }
    }

  }

  public static void init_attackzone() throws IOException {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        attack_zone[i][j] = false;
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (queen[i][j]) {
          attack_marking(j, i);
        }
      }
    }

  }

}