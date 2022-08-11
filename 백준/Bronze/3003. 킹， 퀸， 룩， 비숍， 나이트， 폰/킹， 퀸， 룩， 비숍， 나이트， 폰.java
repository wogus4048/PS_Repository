import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int num;
  static int[] arr = { 1, 1, 2, 2, 2, 8 };

  public static void main(String[] args) throws IOException {
    input();
    solve();
    // test();

    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {

  }

  public static void solve() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 6; i++) {
      bw.write(arr[i] - Integer.parseInt(st.nextToken()) + " ");
    }

  }

  static void test() throws IOException {

  }

}