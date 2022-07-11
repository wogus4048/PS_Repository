import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static int m;
  static boolean[] check;
  static ArrayList<Integer>[] List;
  static int count;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // 1베이스로 만들기 위해 정점의 개수 +1 개로 만듬
    check = new boolean[n + 1];
    Arrays.fill(check, false);

    List = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) {
      List[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(temp.nextToken());
      int b = Integer.parseInt(temp.nextToken());

      List[a].add(b);
      List[b].add(a);
    }

    for (int i = 1; i <= n; i++) {
      Collections.sort(List[i]);
    }

  }

  static void solve() throws IOException {
    // for (boolean c : check) {
    // bw.write(c + " ");
    // }
    // bw.write("\n");
    // for (int i = 1; i <= n; i++) {
    // bw.write(List[i].toString() + "\n");
    // }
    for (int i = 1; i <= n; i++) {
      if (!check[i]) {
        dfs(i);
        count++;
      }
    }
    bw.write(count + "");

  }

  static void test() throws IOException {

  }

  static void dfs(int node_index) throws IOException {
    if (check[node_index]) {
      return;
    }

    check[node_index] = true;

    for (int i = 0; i < List[node_index].size(); i++) {
      int temp = List[node_index].get(i);
      if (!check[temp]) {
        dfs(temp);
      }

    }

  }

}
