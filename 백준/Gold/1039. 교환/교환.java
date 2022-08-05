import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int number, k, result;
  static boolean[][] visited = new boolean[1000001][11];

  public static void main(String[] args) throws IOException {
    input();
    solve();
    // test();

    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    number = Integer.parseInt(st.nextToken());

    k = Integer.parseInt(st.nextToken());

    result = -1;

  }

  public static void solve() throws IOException {
    dfs(number, 0);
    bw.write(result + "");
  }

  static void dfs(int current_number, int current_k) throws IOException {
      visited[current_number][current_k] = true;

    if (current_k == k) {
      result = Math.max(result, current_number);
      return;
    }
    int length = String.valueOf(current_number).length();

    for (int i = 0; i < length - 1; i++) {
      for (int j = i + 1; j < length; j++) {
        int swap_result = swap(current_number, i, j);
        if (swap_result != -1 && !visited[swap_result][current_k + 1]) {
          visited[swap_result][current_k + 1] = true;
          dfs(swap_result, current_k + 1);
        }

      }

    }

  }

  static int swap(int number, int i, int j) {
    char[] arr = String.valueOf(number).toCharArray();

    if (i == 0 && arr[j] == '0') {
      return -1;
    } else {
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;

      return Integer.parseInt(new String(arr));
    }

  }

  static void test() throws IOException {

  }

}