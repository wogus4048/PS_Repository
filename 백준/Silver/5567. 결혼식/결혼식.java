import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, m, count;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> al = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    count = 0;

    visited = new boolean[n + 1];

    for (int j = 0; j <= n; j++) {
      al.add(new ArrayList<>()); // 초기화.
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (!al.get(a).contains(b)) // 중복체크
      {
        al.get(a).add(b);
      }

      if (!al.get(b).contains(a)) // 중복체크 , 양방향이므로 b에도 a를 저장
      {
        al.get(b).add(a);
      }

    }

    // for (ArrayList<Integer> aa : al) {
    // bw.write(aa.toString() + " ");
    // }
    // bw.write(al.size() + "");

  }

  static void solve() throws IOException {
    dfs(1, 0);

    for (int i = 2; i <= n; i++) // 1based 이므로 n이 포함되어야함
    {
      if (visited[i]) {
        count++;
      }
    }
    bw.write(count + "");

  }

  static void dfs(int node_index, int depth) throws IOException {
    ArrayList<Integer> temp = al.get(node_index);
    visited[node_index] = true; // 해당 노드 방문처리해준다.

    if (depth == 2) { // depth가 2라면 함수종료
      // bw.write(temp.toString() + "\n");
      return;
    }

    for (int i = 0; i < temp.size(); i++) {
      dfs(temp.get(i), depth + 1);

    }

  }

}
