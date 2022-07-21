import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int num, count;
  static ArrayList<Integer>[] list;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    num = Integer.parseInt(br.readLine());
    list = new ArrayList[num + 1]; // 1based 를 위해 1개더 . 1번 컴퓨터가 인덱스 1을 쓰기위함
    visited = new boolean[num + 1];

    for (int a = 0; a < list.length; a++) {
      list[a] = new ArrayList<>();
    }

    int list_num = Integer.parseInt(br.readLine());

    for (int i = 0; i < list_num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      // 양방향 저장
      if (!list[a].contains(b)) // 중복제거
      {
        list[a].add(b);
      }
      if (!list[b].contains(a)) {
        list[b].add(a);
      }
    }

  }

  static void solve() throws IOException {
    dfs(1);

    count = 0;

    for (int i = 0; i < visited.length; i++) {
      if (visited[i]) {
        count++;
      }
    }
    bw.write(count - 1 + "");

  }

  static void dfs(int node_index) throws IOException {

    visited[node_index] = true;
    ArrayList<Integer> temp = list[node_index];

    for (int i = 0; i < temp.size(); i++) {
      if (!visited[temp.get(i)]) {
        dfs(temp.get(i));
      }
    }

  }

}
